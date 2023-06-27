package com.example.cours.back.model;

import lombok.*;

@Data
@Builder
public class RegisterRequest {

    private String name;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
