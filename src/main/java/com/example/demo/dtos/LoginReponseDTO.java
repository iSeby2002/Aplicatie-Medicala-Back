package com.example.demo.dtos;

import com.example.demo.model.Medic;
import lombok.Data;

@Data
public class LoginReponseDTO {
    private Medic medic;
    private String mesaj;
}
