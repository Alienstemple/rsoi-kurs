package com.example.gateway1.controller;

import com.example.gateway1.AuthService;
import com.example.gateway1.pojo.SignInRequest;
import com.example.gateway1.pojo.SignUpRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    private AuthService authService;

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @GetMapping("/register")
    public String registerPage() { return "register"; }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        SignUpRequest signUpRequest = new SignUpRequest(username, password, new ArrayList<>());
        authService.registerUser(signUpRequest);
        return "login";
    }

    @PostMapping("/login")
    public String auth(@RequestParam String username, @RequestParam String password) {
        SignInRequest signInRequest = new SignInRequest(username, password);
        String jwt = authService.authUser(signInRequest);
        return "parts-search";
    }
}
