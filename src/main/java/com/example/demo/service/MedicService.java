package com.example.demo.service;

import com.example.demo.dtos.LoginDto;
import com.example.demo.dtos.LoginReponseDTO;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.model.Medic;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Component
public interface MedicService {

    LoginReponseDTO logIn(LoginDto loginDto);
    Medic register(RegisterDto registerDto);

    //String deleteAccount(LoginDto loginDto);

    //List<Medic> getAll();

    //Medic removeUser(UUID id);

    //Medic updateUser(Medic medic);

}
