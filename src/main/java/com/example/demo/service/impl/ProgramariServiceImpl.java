package com.example.demo.service.impl;

import com.example.demo.dtos.PacientDto;
import com.example.demo.dtos.ProgramareDTO;
import com.example.demo.model.Pacient;
import com.example.demo.model.Programari;
import com.example.demo.model.SlotProgramari;
import com.example.demo.repository.ProgramariRepository;
import com.example.demo.service.PacientService;
import com.example.demo.service.ProgramariService;
import com.example.demo.service.SlotProgramariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class ProgramariServiceImpl implements ProgramariService{
    private final ProgramariRepository programariRepository;
    private final SlotProgramariService slotProgramariService;
    private final PacientService pacientService;


    @Autowired
    public ProgramariServiceImpl(ProgramariRepository programariRepository, SlotProgramariService slotProgramariService, PacientService pacientService) {
        this.programariRepository = programariRepository;
        this.slotProgramariService = slotProgramariService;
        this.pacientService = pacientService;
    }

    @Override
    public String saveProgramare(ProgramareDTO programareDTO) {
//                System.out.println(programareDTO.getNumeSiPrenume() + " " + programareDTO.getCnp() + " " +
//                programareDTO.getTipDiabetZaharat() + " " + programareDTO.getDiabetZaharat() + " " +
//                programareDTO.getDataDiagnosticului() + " " + programareDTO.getDataProgramarii() + " " +
//                programareDTO.getOraProgramarii());

        PacientDto pacientDto = PacientDto.builder()
                .numePrenume(programareDTO.getNumeSiPrenume())
                .cnp(programareDTO.getCnp())
                .diabetZaharat(programareDTO.getTipDiabetZaharat())
                .diabetZaharatField(programareDTO.getDiabetZaharat())
                .dataDiagnosticului(programareDTO.getDataDiagnosticului())
                .build();
        Pacient savedPacient = pacientService.registerPacient(pacientDto);


        SlotProgramari slot = slotProgramariService.findSlotProgramariByStartTime(programareDTO.getOraProgramarii());
        //System.out.println(slot.getId() + " " + slot.getStartTime() + " " + slot.getEndTime() + " " + slot.isAvailable());
        slot.setAvailable(false);
        slotProgramariService.save(slot);

        Programari programare = Programari.builder()
                .pacient(savedPacient)
                .slot(slot)
                .startTime(slot.getStartTime())
                .endTime(slot.getEndTime())
                .build();
        programariRepository.save(programare);

        return "Programare reusita";
    }
}
