package org.hospital.hospitalmanagementsystem.patient;

import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public Patient savePatient(PatientRequest request) {

        return Patient.builder()
                .dob(request.getDob())
                .name(request.getName())
                .gender(request.getGender())
                .build();
    }

    public PatientResponse getPatientResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .dob(patient.getDob())
                .gender(patient.getGender())
                .build();
    }

    public Patient updatePatientDetails(Long patientId, Patient patientDetails) {
        return Patient.builder()
                .gender(patientDetails.getGender())
                .dob(patientDetails.getDob())
                .name(patientDetails.getName())
                .id(patientId)
                .build();
    }
}
