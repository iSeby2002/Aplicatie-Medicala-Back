package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class SlotProgramari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean available;

    //@OneToOne(mappedBy = "slot")
    //@JsonManagedReference
    //private Programari programari;
}
