package com.example.cours.back.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Integer DownloadsRemaining;
    @Enumerated(EnumType.STRING)
    private Role role;




    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DownloadStatistics> downloadStatistics;

    public Integer getDownloadsRemaining() {
        if (DownloadsRemaining == null) {
            return 5;
        }
        return DownloadsRemaining;
    }}




