package com.example.cours.back.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DownloadStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfDownloads;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
