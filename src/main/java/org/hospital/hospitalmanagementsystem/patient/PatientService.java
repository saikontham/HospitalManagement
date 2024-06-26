package org.hospital.hospitalmanagementsystem.patient;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;
    public String registerPatient(PatientRequest request) {

        if (request!=null) {
            Patient patient = patientMapper.savePatient(request);
            patientRepository.save(patient);
            return "Added Patient";
        }
        return null;
    }

    public String updatePatient(Long patientId, Patient patientDetails) {
        patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        Patient patient1 = patientMapper.updatePatientDetails(patientId, patientDetails);
        patientRepository.save(patient1);
        return "Updated patient details";
    }

    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patientRepository.delete(patient);    }

    public PatientResponse getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        return patientMapper.getPatientResponse(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
//
//    public List<Appointment> getAppointmentsForPatient(Long patientId) {
//        // Implement retrieval logic for appointments of a patient
//    }
}