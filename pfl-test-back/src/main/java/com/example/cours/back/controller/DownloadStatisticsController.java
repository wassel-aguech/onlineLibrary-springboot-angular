package com.example.cours.back.controller;


import com.example.cours.back.model.Book;
import com.example.cours.back.model.User;
import com.example.cours.back.service.DownloadStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Statistics")
public class DownloadStatisticsController {

    @Autowired
    private DownloadStatisticsService downloadStatisticsService;

    @PostMapping("/download")
    public void downloadBook(@RequestBody DownloadRequest downloadRequest) {
        Book book = downloadRequest.getBook();
        User user = downloadRequest.getUser();
        downloadStatisticsService.addDownloadStatistic(book, user);
    }
    public static class DownloadRequest {
        private Book book;
        private User user;
        public Book getBook() {
            return book;
        }
        public void setBook(Book book) {
            this.book = book;
        }
        public User getUser() {
            return user;
        }
        public void setUser(User user) {
            this.user = user;
        }
    }
}
