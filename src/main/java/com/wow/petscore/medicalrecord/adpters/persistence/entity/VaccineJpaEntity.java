package com.wow.petscore.medicalrecord.adpters.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vaccine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineJpaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String type;

    private String number;

    @ManyToOne
    private MedicalRecordJpaEntity medicalRecord;
}
