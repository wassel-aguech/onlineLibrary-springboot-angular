package com.example.pfltestback.service;

import com.example.pfltestback.entity.Book;
import com.example.pfltestback.entity.DownloadStatistics;
import com.example.pfltestback.repository.DownloadStatisticsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
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

