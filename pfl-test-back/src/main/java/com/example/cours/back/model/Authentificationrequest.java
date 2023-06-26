package com.example.cours.back.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Authentificationrequest {


    private String email;
    private String password;
}
