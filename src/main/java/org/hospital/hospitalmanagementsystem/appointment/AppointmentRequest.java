package org.hospital.hospitalmanagementsystem.appointment;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
public class AppointmentRequest {
    Long doctorId;
    Long patientId;
    LocalDateTime dateTime;
}
