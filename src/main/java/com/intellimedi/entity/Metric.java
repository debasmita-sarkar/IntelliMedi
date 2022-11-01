package com.intellimedi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Setter
@Getter
@Builder
@Entity
@Table(name = "Metric")
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @Column
    String name;
    @Column
    int minThreshold;
    @Column
    int maxThreshold;
}
