package com.example.demo.controller;

import com.example.demo.dtos.DataProgramareDTO;
import com.example.demo.dtos.ProgramareDTO;
import com.example.demo.model.SlotProgramari;
import com.example.demo.service.ProgramariService;
import com.example.demo.service.SlotProgramariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/programari")
public class ProgramariController {
    private final SlotProgramariService slotProgramariService;
    private final ProgramariService programariService;
    @Autowired
    public ProgramariController(SlotProgramariService slotProgramariService, ProgramariService programariService){
        this.slotProgramariService=slotProgramariService;
        this.programariService=programariService;
    }
//    @PostMapping("/generate-slots")
//    public ResponseEntity<Void> generateSlots() {
//        slotProgramariService.generareSloturiSaptamanale();
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @GetMapping("/slots")
    public ResponseEntity<List<SlotProgramari>> getAllSlots() {
        List<SlotProgramari> slots = (List<SlotProgramari>) slotProgramariService.findAll();
        return new ResponseEntity<>(slots, HttpStatus.OK);
    }
   /* @PostMapping("/book")
    public ResponseEntity<?> bookAppointment(@RequestBody Programari programari) {
        try {
            Programari saveProgramare = programariService.saveProgramare(programari);
            return new ResponseEntity<>(saveProgramare, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }*/
//   @PostMapping("/book")
//   public ResponseEntity<?> bookAppointment(@RequestBody Programari programari) {
//       try {
//           // Verifică dacă slotul este valid și disponibil
//           Optional<SlotProgramari> optionalSlot = slotProgramariService.findById(programari.getSlot().getId());
//
//           if (optionalSlot.isPresent()) {
//               SlotProgramari slot = optionalSlot.get();
//               if (slot.isAvailable()) {
//                   slot.setAvailable(false);
//                   programari.setSlot(slot);
//                   slotProgramariService.save(slot);
//
//                   // Setează startTime și endTime în funcție de slot
//                   programari.setStartTime(slot.getStartTime());
//                   programari.setEndTime(slot.getEndTime());
//
//                   Programari saveProgramare = programariService.saveProgramare(programari);
//                   return new ResponseEntity<>(saveProgramare, HttpStatus.CREATED);
//               } else {
//                   return new ResponseEntity<>("Slotul nu este disponibil.", HttpStatus.BAD_REQUEST);
//               }
//           } else {
//               return new ResponseEntity<>("Slotul nu există.", HttpStatus.BAD_REQUEST);
//           }
//       } catch (Exception e) {
//           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//       }
//   }

    @PostMapping("/getAvailableSlots")
    public ResponseEntity<List<SlotProgramari>> getAvailableSlots(@RequestBody DataProgramareDTO dataProgramareDTO) {
        List<SlotProgramari> slots = slotProgramariService.findAvailableSlotsByDataProgramarii(dataProgramareDTO.getDataProgramare());
        return new ResponseEntity<>(slots, HttpStatus.OK);
    }

    @PostMapping("/programare")
    public ResponseEntity<?> programare(@RequestBody ProgramareDTO programareDTO) {
       String mesaj = programariService.saveProgramare(programareDTO);
       if(mesaj.equals("Programare reusita")) {
           return new ResponseEntity<>(mesaj, HttpStatus.OK);
       }
       return new ResponseEntity<>(mesaj, HttpStatus.BAD_REQUEST);
    }
}
