package com.example.pfltestback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String Author;
    private String Description;
    private String file;


    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonProperty("category_id")
    private Category category;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<DownloadStatistics> downloadStatistics;

}
