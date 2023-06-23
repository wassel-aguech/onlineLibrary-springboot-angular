package com.example.pfltestback.controller;

import com.example.pfltestback.entity.Authentificationrequest;
import com.example.pfltestback.entity.RegisterRequest;
import com.example.pfltestback.response.AuthentificationResponse;
import com.example.pfltestback.service.AuthentificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthentificationController {


    private AuthentificationService authentificationService;
    private AuthentificationResponse authentificationResponse;
    private Authentificationrequest authentificationrequest;

    //@PostMapping("/register")
    //public ResponseEntity<AuthentificationResponse> register(@RequestBody RegisterRequest request){
      //  return ResponseEntity.ok(authentificationService.register(request));
    //}

    //@PostMapping("/authenticate")
    //public ResponseEntity<AuthentificationResponse> authenticate(@RequestBody Authentificationrequest request){
      //  return ResponseEntity.ok(authentificationService.authenticate(request));

    //}
}
