package org.hospital.hospitalmanagementsystem.medical;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hospital.hospitalmanagementsystem.patient.Patient;
import org.hospital.hospitalmanagementsystem.patient.PatientResponse;
import org.springframework.stereotype.Service;

@Service
public class MedicalMapper {

    public MedicalRecord savePatientMedicalRecord(MedicalRecordRequest medicalRecord,Patient patient) {
        return MedicalRecord.builder()
                .medications(medicalRecord.getMedications())
                .diagnosis(medicalRecord.getDiagnosis())
                .patient(patient)
                .build();
    }
}
