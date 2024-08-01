package com.example.demo.service.impl;


import com.example.demo.dtos.LoginDto;
import com.example.demo.dtos.LoginReponseDTO;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.model.Medic;
import com.example.demo.repository.MedicRepository;
import com.example.demo.service.MedicService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


@Service
public class MedicServiceImpl implements MedicService {

    private final MedicRepository medicRepository;

    public MedicServiceImpl(MedicRepository medicRepository){
        this.medicRepository = medicRepository;
    }

    @Override
    public LoginReponseDTO logIn(LoginDto loginDto) {
        Medic a = medicRepository.findFirstByEmail(loginDto.getEmail());
        LoginReponseDTO loginReponseDTO = new LoginReponseDTO();
        if(a == null){
            loginReponseDTO.setMedic(null);
            loginReponseDTO.setMesaj("Nu exista cont cu acest email!");
        }else {
            if (hashPassword(loginDto.getPassword()).equals(a.getPassword())) {
                loginReponseDTO.setMedic(a);
                loginReponseDTO.setMesaj("Logare cu succes!");
            } else {
                loginReponseDTO.setMedic(null);
                loginReponseDTO.setMesaj("Email-ul sau parola sunt incorecte!");
            }
        }
        return loginReponseDTO;
    }

    @Override
    public Medic register(RegisterDto registerDto) {
        if(!isValidRole(registerDto.getRole())){
            throw new IllegalArgumentException("Rol invalid. Rolul trebuie sa fie 'oftalmolog' sau 'diabetolog'");
        }
        Medic medic = Medic.builder()
                .nume(registerDto.getNume())
                .prenume(registerDto.getPrenume())
                .email(registerDto.getEmail())
                .password(hashPassword(registerDto.getPassword()))
                .phoneNumber(registerDto.getPhoneNumber())
                .role(registerDto.getRole()).build();

        medicRepository.save(medic);
        return medic;
    }
    private boolean isValidRole(String role)
    {
        return "oftalmolog".equalsIgnoreCase(role)|| "diabetolog".equalsIgnoreCase(role);
    }

    private String hashPassword(String password) {
        try {
            // Sercured Hash Algorithm - 256
            // 1 byte = 8 biți
            // 1 byte = 1 char
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
