package com.example.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDto {

    private String phoneNumber;

    private String password;


    private String nume;


    private String prenume;


    private String email;


    private String role;
}
