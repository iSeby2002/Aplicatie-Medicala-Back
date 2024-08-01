package com.example.demo.controller;

import com.example.demo.dtos.LoginDto;
import com.example.demo.dtos.LoginReponseDTO;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.model.Medic;
import com.example.demo.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/medici")
public class MedicController {
    private final MedicService medicService;
    @Autowired
    public MedicController(MedicService medicService)
    {
        this.medicService=medicService;
    }
    @PostMapping("/register")
    public ResponseEntity<Medic> register(@RequestBody RegisterDto registerDto){
        Medic medic=medicService.register(registerDto);
        return new ResponseEntity<>(medic, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginReponseDTO> login(@RequestBody LoginDto loginDto)
    {
        LoginReponseDTO loginReponseDTO = medicService.logIn(loginDto);
        if(loginReponseDTO != null)
        {
            return new ResponseEntity<>(loginReponseDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }
}
