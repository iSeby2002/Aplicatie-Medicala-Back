package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder

public class FisaMedicala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nrCrt;
    @ManyToOne
    @JoinColumn(name = "programare_id")
    private Programari programari;
    //box2
    private double HbA1C;
    private String tipHbA1C;//luni

    private double glicemie;
    private double uree;
    private double creatinina;
    private double eRFG;
    private boolean hta;
    private boolean neuropatie;
    private boolean nefropatie;
    private boolean ci;
    private boolean avc;
    private boolean ima;
    private boolean hipercolesterolomie;

    private boolean hipertrigliceridemie;
    private boolean insulina;
    private boolean ado;
    private boolean dieta;
    private boolean nimic;

    //box3
    private String detaliiFundDeOchi;
    private String alteModalitatiOculare;
    private double acuitateVizualaOD;
    private double acuitateVizualaOS;
    private boolean rubeozaIrianaOD;
    private boolean rubeozaIrianaOS;

    private boolean faraRetinopatieDiabeticaOD;
    private boolean faraRetinopatieDiabeticaOS;

    private boolean retinopatieDiabeticaNeproliferativaUsoaraOD;
    private boolean retinopatieDiabeticaNeproliferativaUsoaraOS;
    private boolean retinopatieDiabeticaNeproliferativaMedieOD;
    private boolean retinopatieDiabeticaNeproliferativaMedieOS;
    private boolean retinopatieDiabeticaNeproliferativaSeveraOD;
    private boolean retinopatieDiabeticaNeproliferativaSeveraOS;
    private boolean retinopatieDiabeticaProliferativaOD;

    private boolean retinopatieDiabeticaProliferativaOS;

    private boolean edemMacularClinicSemnificativOD;
    private boolean edemMacularClinicSemnificativOS;

    private boolean comparativCuUltimaExaminareLaFelOD;
    private boolean comparativCuUltimaExaminareLaFelOS;

    private boolean comparativCuUltimaExaminareMaiBineOS;
    private boolean comparativCuUltimaExaminareMaiBineOD;
    private boolean comparativCuUltimaExaminareMaiRauOD;
    private boolean comparativCuUltimaExaminareMaiRauOS;
    private boolean comparativCuUltimaExaminareNuSeCunoasteOD;
    private boolean comparativCuUltimaExaminareNuSeCunoasteOS;

    //box4
    private double injectieNumarOS;
    private double injectieDozaOS;
    private double injectieNumarOD;
    private double injectieDozaOD;
    private String laserOD;
    private String laserOS;
    //box5
    private String diagnosticOD;
    private String diagnosticOS;
    //box6
    private String recomandare;
    private String recomandareField;
    private boolean tratament;
    private String tratamentField;

    private boolean peste1An;
    private double pesteLuni;
    private double pesteSaptamani;

    private boolean ambulator;
    private String ambulatorLaField;
    private String ambulatorInField;

    private LocalDate data;
    private String MedicExaminator;

}
