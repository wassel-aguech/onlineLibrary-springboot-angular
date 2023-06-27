package com.example.cours.back.service;

import com.example.cours.back.exeption.FileStorageException;
import com.example.cours.back.filestorageproperties.FileStorageProperties;
import com.example.cours.back.model.Role;
import com.example.cours.back.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;


@Service
public class FileStorageService {
    private final Path fileStorageLocation;
    private final Map<String, Integer> downloadCountMap;
    private static final int MAX_DOWNLOADS_PER_MONTH = 5;


    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
        downloadCountMap = new HashMap<>();

    }

    public String uploadFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            if (!fileName.toLowerCase().endsWith(".pdf")) {
                throw new FileStorageException("Only PDF files are allowed!");
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


    public Resource loadFileAsResource(String fileName, User user) {
        try {
            if (user.getRole() == Role.NORMAL) {
                int downloadsThisMonth = downloadCountMap.getOrDefault(user.getEmail(), 0);
                if (downloadsThisMonth >= MAX_DOWNLOADS_PER_MONTH) {
                    throw new FileStorageException("Sorry! You have exceeded your download limit for this month.");
                }
                downloadCountMap.put(user.getEmail(), downloadsThisMonth + 1);
            }

            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new   FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException | FileNotFoundException ex) {
            throw new FileStorageException("File not found " + fileName, ex);
        }
    }

}



