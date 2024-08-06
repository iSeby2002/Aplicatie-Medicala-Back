package com.example.demo.dtos;

import com.example.demo.model.Medic;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private Medic medic;
    private String mesaj;
}