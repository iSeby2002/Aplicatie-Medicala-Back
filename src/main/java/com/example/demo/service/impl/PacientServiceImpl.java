package com.example.demo.service.impl;

import com.example.demo.dtos.PacientDto;
import com.example.demo.model.Pacient;
import com.example.demo.repository.PacientRepository;
import com.example.demo.service.PacientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientServiceImpl implements PacientService {

    private final PacientRepository pacientRepository;

    public PacientServiceImpl(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    @Override
    public Pacient registerPacient(PacientDto pacientDto) {
        Pacient pacient = Pacient.builder()
                .numePrenume(pacientDto.getNumePrenume())
                .cnp(pacientDto.getCnp())
                .diabetZaharat(pacientDto.getDiabetZaharat())
                .diabetZaharatField(pacientDto.getDiabetZaharatField())
                .dataDiagnosticului(pacientDto.getDataDiagnosticului())
                .build();
        return pacientRepository.save(pacient);
    }

    @Override
    public void deletePacient(Long nrCrt) {
        if (pacientRepository.existsByNrCrt(nrCrt)) {
            Pacient pacient = pacientRepository.findByNrCrt(nrCrt);
            if (pacient != null) {
                pacientRepository.delete(pacient);
            } else {
                throw new RuntimeException("Pacientul cu nrCrt " + nrCrt + " nu a fost găsit");
            }
        } else {
            throw new RuntimeException("Pacientul cu nrCrt " + nrCrt + " nu a fost găsit");
        }
    }

    @Override
    public Pacient updatePacient(Long nrCrt, PacientDto pacientDto) {
        if (pacientRepository.existsByNrCrt(nrCrt)) {
            Pacient pacient = pacientRepository.findByNrCrt(nrCrt);
            if (pacient != null) {
                pacient.setNumePrenume(pacientDto.getNumePrenume());
                pacient.setCnp(pacientDto.getCnp());
                pacient.setDiabetZaharat(pacientDto.getDiabetZaharat());
                pacient.setDataDiagnosticului(pacientDto.getDataDiagnosticului());
                return pacientRepository.save(pacient);
            } else {
                throw new RuntimeException("Pacientul cu nrCrt " + nrCrt + " nu a fost găsit");
            }
        } else {
            throw new RuntimeException("Pacientul cu nrCrt " + nrCrt + " nu a fost găsit");
        }
    }

    @Override
    public Long getNextPacientId() {
        Pageable topOne = PageRequest.of(0, 1);
        List<Pacient> pacients = pacientRepository.findLastPacient(topOne);

        if (!pacients.isEmpty()) {
            Pacient lastPacient = pacients.get(0);
            return lastPacient.getNrCrt() + 1;
        } else {
            return -1L;
        }
    }
}