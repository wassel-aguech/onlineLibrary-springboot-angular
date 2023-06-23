package com.example.pfltestback.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class DownloadStatistics {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfDownloads;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
