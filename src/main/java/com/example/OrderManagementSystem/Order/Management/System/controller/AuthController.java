package com.example.OrderManagementSystem.Order.Management.System.controller;

import com.example.OrderManagementSystem.Order.Management.System.model.AuthRequest;
import com.example.OrderManagementSystem.Order.Management.System.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request){
        Authentication auth =authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        if(auth.isAuthenticated()){
            return jwtUtil.generateToken(request.getUsername());
        }
        throw new RuntimeException("Invalid Credentials");
    }


}
