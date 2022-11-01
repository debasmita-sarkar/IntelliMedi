package com.intellimedi.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.intellimedi.utils.BloodGroup;
import com.intellimedi.utils.Gender;
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
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @Column
    String name;
    @Column
    LocalDate dob;
    @Column
    BloodGroup bloodGroup;
    @Column
    String address;
    @Column
    String phone;
    @Column
    Gender gender;
    @OneToMany(targetEntity = HealthParameters.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId_fk",referencedColumnName = "Id")
    private List<HealthParameters> healthParametersList;

    @OneToMany(targetEntity = HealthParameters.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId_fk",referencedColumnName = "Id")
    private List<DoctorVisit> doctorVisitList;

}
