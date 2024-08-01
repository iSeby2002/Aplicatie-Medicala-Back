package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramareDTO {
    private String numeSiPrenume;
    private Long cnp;
    private String tipDiabetZaharat;
    private String diabetZaharat;
    private LocalDate dataDiagnosticului;
    private LocalDate dataProgramarii;
    private LocalDateTime oraProgramarii;
}
