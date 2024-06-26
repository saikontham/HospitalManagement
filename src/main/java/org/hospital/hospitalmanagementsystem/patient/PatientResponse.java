package org.hospital.hospitalmanagementsystem.patient;

import lombok.*;

import java.time.LocalDate;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponse {
    private Long id;
    private String name;
    private String gender;
    private LocalDate dob;

}
