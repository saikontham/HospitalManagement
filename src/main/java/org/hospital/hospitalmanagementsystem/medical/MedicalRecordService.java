package org.hospital.hospitalmanagementsystem.medical;

import lombok.RequiredArgsConstructor;
import org.hospital.hospitalmanagementsystem.patient.Patient;
import org.hospital.hospitalmanagementsystem.patient.PatientRepository;
import org.hospital.hospitalmanagementsystem.patient.PatientResponse;
import org.hospital.hospitalmanagementsystem.patient.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
        private final MedicalMapper mapper;
        private final PatientRepository patientRepository;
    
    public List<MedicalRecord> getMedicalRecordsByPatientId(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }
    
    public MedicalRecord saveMedicalRecord(MedicalRecordRequest medicalRecord) {
        Patient patient = patientRepository.findById(medicalRecord.getPatientId()).get();
        MedicalRecord record = mapper.savePatientMedicalRecord(medicalRecord, patient);
        patient.setMedicalRecord(record);
        System.out.println(patient.getMedicalRecord());
       return medicalRecordRepository.save(record);
    }
    
}
