package com.example.cours.back.service;

import com.example.cours.back.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

@Autowired
    private UserRepo userRepo;
   // private PasswordEncoder passwordEncoder;
    //private JwtService jwtService;
    //private AuthenticationManager authenticationManager;
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

