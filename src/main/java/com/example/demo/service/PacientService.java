package com.example.demo.service;

import com.example.demo.dtos.PacientDto;
import com.example.demo.model.Pacient;
import org.springframework.stereotype.Component;

@Component
public interface PacientService {
    Pacient registerPacient(PacientDto pacientDto);
    void deletePacient(Long nrCrt);
    Pacient updatePacient(Long nrCrt,PacientDto pacientDto);
    Long getNextPacientId();
}