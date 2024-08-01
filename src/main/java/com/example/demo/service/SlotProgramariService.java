package com.example.demo.service;

import com.example.demo.model.SlotProgramari;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SlotProgramariService  {
    void generareSloturiSaptamanale();
    Iterable<SlotProgramari> findAll();

    Optional<SlotProgramari> findById(Long id);

    SlotProgramari findSlotProgramariByStartTime(LocalDateTime startTime);
    SlotProgramari save(SlotProgramari slotProgramari);

    List<SlotProgramari> findAvailableSlotsByDataProgramarii(LocalDate dataProgramarii);
}
