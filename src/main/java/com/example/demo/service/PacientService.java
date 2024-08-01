package com.example.demo.service;

import com.example.demo.dtos.PacientDto;
import com.example.demo.model.Pacient;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface PacientService {
    Pacient registerPacient(PacientDto pacientDto);
    void deletePacient(Long nrCrt);
    Pacient updatePacient(Long nrCrt,PacientDto pacientDto);
    Long getNextPacientId();
}
