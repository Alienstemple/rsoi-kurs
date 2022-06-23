package com.example.gateway1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SignUpRequest {
    private String username;
    private String password;
    private List<String> roles;
}
