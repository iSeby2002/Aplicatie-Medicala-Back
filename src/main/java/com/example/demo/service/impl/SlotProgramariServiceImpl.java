package com.example.demo.service.impl;

import com.example.demo.model.SlotProgramari;
import com.example.demo.repository.SlotProgramariRepository;
import com.example.demo.service.SlotProgramariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service

public class SlotProgramariServiceImpl implements SlotProgramariService {
    private final SlotProgramariRepository slotProgramariRepository;
    private final int saptamani= 52;
    private final int oraStart=10;
    private final int oraFinal=12;
    private final int durataSlot=15;
    private final int nrSloturi=((12-10)*60)/durataSlot;


    @Autowired
    public SlotProgramariServiceImpl(SlotProgramariRepository slotProgramariRepository) {
        this.slotProgramariRepository = slotProgramariRepository;
    }

    @Override
    public void generareSloturiSaptamanale(){
        LocalDateTime startDate = LocalDateTime.now().withHour(oraStart).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endDate = startDate.withHour(oraFinal);

        List<SlotProgramari> slots = new ArrayList<>();

        for (int week = 0; week < saptamani; week++) { // 1 an
            for (int day = 0; day < 5; day++) {
                LocalDateTime currentDay = startDate.plusWeeks(week).with(DayOfWeek.MONDAY).plusDays(day);
                for (int hour = oraStart; hour < oraFinal; hour++) {
                    for (int minute = 0; minute < 60; minute += durataSlot) {
                        LocalDateTime slotStart = currentDay.withHour(hour).withMinute(minute);
                        LocalDateTime slotEnd = slotStart.plusMinutes(durataSlot);
                        SlotProgramari slot = SlotProgramari.builder()
                                .startTime(slotStart)
                                .endTime(slotEnd)
                                .available(true)
                                .build();
                        slots.add(slot);
                    }
                }
            }
        }
        slotProgramariRepository.saveAll(slots);
    }

    @Override
    public Iterable<SlotProgramari> findAll() {
        return slotProgramariRepository.findAll();
    }

    @Override
    public Optional<SlotProgramari> findById(Long id) {
        return slotProgramariRepository.findById(id);
    }

    @Override
    public SlotProgramari findSlotProgramariByStartTime(LocalDateTime startTime) {
        return slotProgramariRepository.findSlotProgramariByStartTime(startTime);
    }

    @Override
    public SlotProgramari save(SlotProgramari slotProgramari) {
        return slotProgramariRepository.save(slotProgramari);
    }

    @Override
    public List<SlotProgramari> findAvailableSlotsByDataProgramarii(LocalDate dataProgramarii) {
        Iterable<SlotProgramari> allSlots = slotProgramariRepository.findAll();

        List<SlotProgramari> availableSlots = StreamSupport.stream(allSlots.spliterator(), false)
                .filter(slot -> slot.isAvailable() && slot.getStartTime().toLocalDate().equals(dataProgramarii))
                .collect(Collectors.toList());

        return availableSlots;
    }
}
