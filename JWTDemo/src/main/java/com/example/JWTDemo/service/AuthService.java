package com.example.JWTDemo.service;

import com.example.JWTDemo.dto.LoginRequest;
import com.example.JWTDemo.dto.RegisterRequest;
import com.example.JWTDemo.model.User;
import com.example.JWTDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request){
        User user=new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);
        return "user registered successfully";
    }

    public String login(LoginRequest request){
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow(()->new RuntimeException("user not found"));
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("invalid credentials");
        }

        return jwtService.generateToken(user.getUsername());
    }
}
