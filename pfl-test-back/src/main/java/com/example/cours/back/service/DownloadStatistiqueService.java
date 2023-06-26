package com.example.cours.back.service;

import com.example.cours.back.model.Book;
import com.example.cours.back.model.DownloadStatistics;
import com.example.cours.back.model.User;
import com.example.cours.back.repository.DownloadStatisticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadStatistiqueService {

    @Autowired
    private DownloadStatisticsRepo downloadStatisticsRepo;

    public void addDownloadStatistic(Book book, User user) {
        DownloadStatistics downloadStatistics = new DownloadStatistics();
        downloadStatistics.setBook(book);
        //  downloadStatistics.setUser(user);

        downloadStatistics.setNumberOfDownloads(1);
        downloadStatisticsRepo.save(downloadStatistics);
    }
}
