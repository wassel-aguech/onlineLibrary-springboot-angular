package com.example.pfltestback.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {

    private String name;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
