package org.hospital.hospitalmanagementsystem.medical;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicalrecords")
@AllArgsConstructor
public class MedicalRecordController {
    private MedicalRecordService medicalRecordService;
    
    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord> getMedicalRecordsByPatientId(@PathVariable Long patientId) {
        return medicalRecordService.getMedicalRecordsByPatientId(patientId);
    }

    @PostMapping
    public ResponseEntity<?> saveMedicalRecord(@RequestBody MedicalRecordRequest medicalRecord) {
        try {
            MedicalRecord savedRecord = medicalRecordService.saveMedicalRecord(medicalRecord);
            return ResponseEntity.ok().body("Medications Added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save medical record: " + e.getMessage());
        }
    }


}