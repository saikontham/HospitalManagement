package org.hospital.hospitalmanagementsystem.doctor;

import jakarta.persistence.*;
import lombok.*;
import org.hospital.hospitalmanagementsystem.appointment.Appointment;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialization;


    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

}
