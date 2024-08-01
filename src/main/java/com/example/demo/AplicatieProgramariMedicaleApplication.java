package com.example.demo;

import com.example.demo.dtos.PacientDto;
import com.example.demo.dtos.RegisterDto;
import com.example.demo.model.Medic;
import com.example.demo.model.Pacient;
import com.example.demo.service.MedicService;
import com.example.demo.service.PacientService;
import com.example.demo.service.SlotProgramariService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLOutput;
import java.time.LocalDate;

@SpringBootApplication
public class AplicatieProgramariMedicaleApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {

		SpringApplication.run(AplicatieProgramariMedicaleApplication.class, args);

	}

	@Bean
	CommandLineRunner init(MedicService medicService, PacientService pacientService, SlotProgramariService slotProgramariService) {


		return args -> {
			//medici
			RegisterDto registerDto1= RegisterDto.builder()
					.nume("Diana")
					.prenume("Anghelus")
					.phoneNumber("0745706903")
					.role("oftalmolog")
					.email("anghelus_diana@yahoo.com")
					.password("1234")
					.build();
			RegisterDto registerDto2= RegisterDto.builder()
					.nume("Oana")
					.prenume("Ilies")
					.phoneNumber("0745706902")
					.role("oftalmolog")
					.email("oana_ilies@yahoo.com")
					.password("1234")
					.build();
			RegisterDto registerDto3= RegisterDto.builder()
					.nume("Damian")
					.prenume("Sebastian")
					.phoneNumber("0770994687")
					.role("diabetolog")
					.email("damiansebastian2002@gmail.com")
					.password("1234")
					.build();
			Medic savedRegisterDto = medicService.register(registerDto1);
			Medic savedRegisterDto2 = medicService.register(registerDto2);
			Medic savedRegisterDto3 = medicService.register(registerDto3);
			//pacienti diabet
			PacientDto pacientDto1 = PacientDto.builder()
					.numePrenume("Ion Popescu")
					.cnp(1234567890123L)
					.diabetZaharat("tip 2")
					.diabetZaharatField("alabala")
					.dataDiagnosticului(LocalDate.of(2023, 7, 20))
					.build();
			PacientDto pacientDto2 = PacientDto.builder()
					.numePrenume("Delia Costea")
					.cnp(2134567890123L)
					.diabetZaharat("tip 1")
					.diabetZaharatField("alabala")
					.dataDiagnosticului(LocalDate.of(2023, 6, 22))
					.build();
			Pacient savedPacientDto1 = pacientService.registerPacient(pacientDto1);
			Pacient savedPacientDto2 = pacientService.registerPacient(pacientDto2);

			slotProgramariService.generareSloturiSaptamanale();
		};
	}

}