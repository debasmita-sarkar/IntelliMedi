package com.intellimedi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@Entity
@Table(name = "DoctorVisit")
public class DoctorVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @Column
    LocalDateTime visitTime;
    @OneToOne
    @JoinColumn(name = "prescriptionId_fk",referencedColumnName = "Id")
    Prescription prescription;
    @OneToOne
    @JoinColumn(name = "doctorId_fk",referencedColumnName = "Id")
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name = "userId_fk",referencedColumnName = "Id")
    private User user;
}
