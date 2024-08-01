package com.example.demo.controller;

import com.example.demo.dtos.FisaMedicalaDto;
import com.example.demo.model.FisaMedicala;
import com.example.demo.model.Programari;
import com.example.demo.service.FisaMedicalaService;
import com.example.demo.service.MedicService;
import com.example.demo.service.ProgramariService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/medici/fisaMedicala")

public class FisaMedicalaController {
     private final MedicService medicService;
     private final ProgramariService programariService;
     private final FisaMedicalaService fisaMedicalaService;

    public FisaMedicalaController(MedicService medicService, ProgramariService programariService, FisaMedicalaService fisaMedicalaService) {
        this.medicService = medicService;
        this.programariService = programariService;
        this.fisaMedicalaService = fisaMedicalaService;
    }
    @PostMapping("/getProgramariCurente")
    public ResponseEntity<List<Programari>> getProgramariCurente(@RequestBody LocalDate data) {
        List<Programari> programari = fisaMedicalaService.findProgramariCurente(data);
        return new ResponseEntity<>(programari, HttpStatus.OK);
    }

    @PostMapping("/saveFisaMedicala")
    public ResponseEntity<String> saveFisaMedicala(@RequestBody FisaMedicalaDto fisaMedicalaDto){
        String msg = fisaMedicalaService.saveFisaMedicala(fisaMedicalaDto);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
