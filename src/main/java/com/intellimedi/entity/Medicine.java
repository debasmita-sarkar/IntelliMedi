package com.intellimedi.entity;

import com.intellimedi.utils.PartOfDay;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Setter
@Getter
@Builder
@Entity
@Table(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger id;
    @Column
    String name;
}
