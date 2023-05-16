package com.intellimedi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Map;

@Setter
@Getter
@Builder
@Entity
@Table(name = "TestReport")
public class TestReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @Column
    String testName;
    @Column
    LocalDate CollectionDate;
    @Column
    LocalDate reportDate;
    @ManyToOne
    Prescription prescription;
    //TODO - understand how to use map and try view
    //@Column
    //Map<Metric,Double> metrics;
}
