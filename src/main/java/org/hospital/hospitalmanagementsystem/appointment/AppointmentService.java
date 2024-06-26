package org.hospital.hospitalmanagementsystem.appointment;
;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hospital.hospitalmanagementsystem.doctor.Doctor;
import org.hospital.hospitalmanagementsystem.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class  AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final DoctorRepository doctorRepository;

    private final AppointmentMapper appointmentMapper;
    public Appointment scheduleAppointment(AppointmentRequest request) {

            Doctor doctor = doctorRepository.findById(request.doctorId)
                    .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: " + request.doctorId));

            if (isAppointmentFull(doctor.getId(), request.getDateTime()) ) {
            throw new IllegalStateException("Appointment slot is already full for the specified date and time.");
             }
            Appointment appointment = appointmentMapper.scheduleAndSaveAppointment(request,doctor);
            return appointmentRepository.save(appointment);
    }

    public boolean isAppointmentFull(Long doctorId,LocalDateTime dateTime)
    {
        return appointmentRepository.existsByDoctorIdAndDateTime(doctorId, dateTime);
    }



    public void cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + appointmentId));

        appointmentRepository.delete(appointment);
    }

    public AppointmentResponse getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + appointmentId));
        return appointmentMapper.getAppointment(appointment);
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: " + doctorId));

        return appointmentRepository.findByDoctor(doctor);
    }



    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
