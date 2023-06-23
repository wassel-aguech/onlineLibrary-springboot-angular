package com.example.pfltestback.service;

import com.example.pfltestback.entity.RegisterRequest;
import com.example.pfltestback.repository.UserRepo;
import com.example.pfltestback.response.AuthentificationResponse;
import com.example.pfltestback.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;
}
   // public AuthentificationResponse register(RegisterRequest request) {
       // var user = User.builder()
         //       .name(request.getName())
           //     .lastname(request.getLastname())
             //   .email(request.getEmail())
               // .password(passwordEncoder.encode(request.getPassword()))
                //.role(request.getRole())
                //.build();
        //if(!userRepo.existsByEmail(request.getEmail())){
          //  userRepo.save(user);
            //var jwtToken = jwtService.generateToken(user);
            //return AuthentificationResponse.builder().token(jwtToken).build();
        //}else{
         //   throw new RuntimeException("Email exists");
        //}



   // public <AuthentificationRequest> AuthentificationResponse authenticate(AuthentificationRequest request) {
     //   try {
       //     authenticationManager.authenticate(
         //           new UsernamePasswordAuthenticationToken(request.getClass(), request)
           // );
        //} catch (AuthenticationException e) {
          //  System.out.println("Authentication failed: " + e.getMessage());
            //throw e;
        //}
        //var user = userRepo.findByEmail(request.getClass()).orElseThrow();
        // var jwtToken = jwtService.generateToken(user);//generate token
        //return AuthentificationResponse.builder().token(jwtToken).build();
        //}
//}


