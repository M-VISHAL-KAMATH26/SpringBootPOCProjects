package com.poc.jobportal.dto;


import com.poc.jobportal.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
