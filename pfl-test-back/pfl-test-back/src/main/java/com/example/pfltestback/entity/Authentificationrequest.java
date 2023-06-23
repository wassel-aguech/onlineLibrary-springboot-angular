package com.example.pfltestback.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Authentificationrequest {

    private String email;
    private String password;
}
