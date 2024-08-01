package com.example.demo.repository;

import com.example.demo.model.SlotProgramari;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface SlotProgramariRepository extends CrudRepository<SlotProgramari,Long> {

    SlotProgramari findSlotProgramariByStartTime(LocalDateTime startTime);
}
