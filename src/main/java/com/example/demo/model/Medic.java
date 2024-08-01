package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Medic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain exactly 10 digits")
    private String phoneNumber;

    @NotNull
    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull
    private String nume;

    @NotNull
    private String prenume;

    @NonNull
    private String email;

    @NotNull
    private String role;
}
