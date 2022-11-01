package com.intellimedi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@Entity
@Table(name = "Prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @OneToOne
    DoctorVisit doctorVisit;
    @OneToMany
    List<PrescribedMedicine> PrescribedMedicine;
    @Column
    String symptoms;
    @Column
    LocalDateTime nextVisitTime;
}
