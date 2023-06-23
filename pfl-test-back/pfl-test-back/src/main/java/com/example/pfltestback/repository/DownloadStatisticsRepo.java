package com.example.pfltestback.repository;

import com.example.pfltestback.entity.DownloadStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadStatisticsRepo extends JpaRepository <DownloadStatistics, Integer> {
}
