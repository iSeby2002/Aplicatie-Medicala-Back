package com.example.demo.service;

import com.example.demo.dtos.FisaMedicalaDto;
import com.example.demo.model.Programari;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public interface FisaMedicalaService {
    List<Programari> findProgramariCurente(LocalDate data);
    String saveFisaMedicala(FisaMedicalaDto fisaMedicalaDto);
}