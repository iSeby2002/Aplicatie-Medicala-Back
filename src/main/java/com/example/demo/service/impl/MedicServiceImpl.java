package com.example.demo.service.impl;

import com.example.demo.dtos.LoginDto;
import com.example.demo.dtos.LoginResponseDTO;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.dtos.RegisterResponseDTO;
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
    public LoginResponseDTO logIn(LoginDto loginDto) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        Medic medic = medicRepository.findFirstByEmail(loginDto.getEmail());
        if(medic == null){
            loginResponseDTO.setMedic(null);
            loginResponseDTO.setMesaj("Nu există cont cu acest email!");
        }else{
            if(hashPassword(loginDto.getPassword()).equals(medic.getPassword())) {
                loginResponseDTO.setMedic(medic);
                loginResponseDTO.setMesaj("Logare cu succes!");
            }else{
                loginResponseDTO.setMedic(null);
                loginResponseDTO.setMesaj("Email-ul sau parola sunt incorecte!");
            }
        }
        return loginResponseDTO;
    }

    @Override
    public RegisterResponseDTO register(RegisterDto registerDto) {
        RegisterResponseDTO registerResponseDTO = new RegisterResponseDTO();
        Medic medic = medicRepository.findFirstByEmail(registerDto.getEmail());
        if(medic != null){
            registerResponseDTO.setMedic(null);
            registerResponseDTO.setMesaj("Există deja un cont acest email!");
        }else if(!isValidRole(registerDto.getRole())) {
            registerResponseDTO.setMedic(null);
            registerResponseDTO.setMesaj("Rol invalid. Rolul trebuie sa fie \"oftalmolog\" sau \"diabetolog\" !");
        }else{
            Medic medicNou = Medic.builder()
                    .nume(registerDto.getNume())
                    .prenume(registerDto.getPrenume())
                    .email(registerDto.getEmail())
                    .password(hashPassword(registerDto.getPassword()))
                    .phoneNumber(registerDto.getPhoneNumber())
                    .role(registerDto.getRole())
                    .build();
            medicRepository.save(medicNou);
            registerResponseDTO.setMedic(medicNou);
            registerResponseDTO.setMesaj("Înregistrare cu succes!");
        }
        return registerResponseDTO;
    }

    private boolean isValidRole(String role) {
        return "oftalmolog".equalsIgnoreCase(role) || "diabetolog".equalsIgnoreCase(role);
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