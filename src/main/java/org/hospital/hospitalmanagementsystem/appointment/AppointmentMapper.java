package org.hospital.hospitalmanagementsystem.appointment;

import org.hospital.hospitalmanagementsystem.doctor.Doctor;
import org.springframework.stereotype.Service;

@Service

public class AppointmentMapper {
    public Appointment scheduleAndSaveAppointment(AppointmentRequest request, Doctor doctor) {
        return Appointment.builder()
                .doctor(doctor)
                .dateTime(request.getDateTime())
                .patientId(request.patientId)
                .build();
    }

    public AppointmentResponse getAppointment(Appointment appointment) {

        return AppointmentResponse.builder()
                .dateTime(appointment.getDateTime())
                .doctorId(appointment.getDoctor().getId())
                .patientId(appointment.getPatientId())
                .build();
    }
}
