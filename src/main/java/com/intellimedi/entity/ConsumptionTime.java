package com.intellimedi.entity;

import com.intellimedi.utils.PartOfDay;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.Calendar;

@Setter
@Getter
@Builder
@Entity
@Table(name = "Consumption_Time")
public class ConsumptionTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @Column
    PartOfDay partOfDay;
    @Column
    LocalTime alarmTime;

}
