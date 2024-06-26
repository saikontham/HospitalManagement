package org.hospital.hospitalmanagementsystem.appointment;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class AppointmentResponse {
    Long doctorId;
    Long patientId;
    LocalDateTime dateTime;
}
