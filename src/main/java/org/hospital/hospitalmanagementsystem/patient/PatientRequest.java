package org.hospital.hospitalmanagementsystem.patient;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PatientRequest {
    private String name;
    private String gender;
    private LocalDate dob;
}
