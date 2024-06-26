package org.hospital.hospitalmanagementsystem.medical;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicalRecordRequest {
    Long patientId;
    String diagnosis;
    String medications;
}
