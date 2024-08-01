package com.example.demo.controller;

import com.example.demo.dtos.PacientDto;
import com.example.demo.model.Pacient;
import com.example.demo.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/pacienti")
public class PacientController {
    private final PacientService pacientService;
    @Autowired
    public PacientController(PacientService pacientService){
        this.pacientService=pacientService;
    }

    @PostMapping("/register")
    public ResponseEntity<Pacient> register(@RequestBody PacientDto pacientDto){
        Pacient pacient=pacientService.registerPacient(pacientDto);
        return new ResponseEntity<>(pacient, HttpStatus.CREATED);
    }
    @DeleteMapping("/{nrCrt}")
    public ResponseEntity<Void> delete(@PathVariable Long nrCrt){
        try{
            pacientService.deletePacient(nrCrt);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{nrCrt}")
    public ResponseEntity<Pacient> update(@PathVariable Long nrCrt, @RequestBody PacientDto pacientDto){
        try{
            Pacient updatedPacient=pacientService.updatePacient(nrCrt,pacientDto);
            return new ResponseEntity<>(updatedPacient,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUrmatorulNrCrt")
    public ResponseEntity<Long> getUrmatorulNrCrt(){
        Long nextNrCrt = pacientService.getNextPacientId();
        return new ResponseEntity<>(nextNrCrt,HttpStatus.OK);
    }
}
