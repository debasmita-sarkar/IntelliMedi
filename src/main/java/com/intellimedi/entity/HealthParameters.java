package com.intellimedi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@Entity
@Table(name = "Health_Params")
public class HealthParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
   //TODO discuss if here user is required
    @ManyToOne
    User user;
    @Column
    int heightInFt;
    @Column
    int weightInKg;
    @Column
    LocalDate dateOfMeasurement;
    @Column
    String bloodPressureinHgmm;
}
