package org.hospital.hospitalmanagementsystem.appointment;

import org.hospital.hospitalmanagementsystem.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctor(Doctor doctor);

    List<Appointment> findByPatientId(Long patientId);


    boolean existsByDoctorIdAndDateTime(Long doctorId, LocalDateTime dateTime);
}
