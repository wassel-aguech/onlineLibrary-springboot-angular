package com.example.cours.back.repository;

import com.example.cours.back.model.DownloadStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadStatisticsRepo extends JpaRepository<DownloadStatistics, Long> {
}
