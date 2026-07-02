package com.example.JWTDemo.dto;

import com.example.JWTDemo.model.Role;
import lombok.Data;


@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
