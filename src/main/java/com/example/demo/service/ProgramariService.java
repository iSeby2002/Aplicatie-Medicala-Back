package com.example.demo.service;

import com.example.demo.dtos.ProgramareDTO;
import org.springframework.stereotype.Component;

@Component
public interface ProgramariService {
    String saveProgramare(ProgramareDTO programareDTO);
}