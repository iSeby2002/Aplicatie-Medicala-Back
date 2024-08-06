package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
@Entity
@Builder
public class Programari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;
    @OneToOne
    @JoinColumn(name = "slot_id")
    private SlotProgramari slot;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}