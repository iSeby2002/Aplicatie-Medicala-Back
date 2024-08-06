package com.example.demo.service;

import com.example.demo.dtos.LoginDto;
import com.example.demo.dtos.LoginResponseDTO;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.dtos.RegisterResponseDTO;
import org.springframework.stereotype.Component;

@Component
public interface MedicService {
    LoginResponseDTO logIn(LoginDto loginDto);
    RegisterResponseDTO register(RegisterDto registerDto);
}