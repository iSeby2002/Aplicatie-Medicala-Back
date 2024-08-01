package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder

public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nrCrt;

    private String numePrenume;


    private long cnp;
    private String diabetZaharat;
    private String diabetZaharatField;
    private LocalDate dataDiagnosticului;

}
