package com.intellimedi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
@Entity
@Table(name = "PrescribedMedicine")
public class PrescribedMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @OneToOne
    Medicine medicine;
    @Column
    String purpose;
    @Column
    String frequency;
    @Column
    String comment;
    @Column
    String dosage;
    @Column
    LocalDate startDate;
    @Column
    int duration;
    @Transient
    LocalDate endDate;
    @OneToMany
    List<ConsumptionTime> consumptionTimes;
    @ManyToOne
    Prescription prescription;
    // add view for user
    @Transient
    User user;
}

