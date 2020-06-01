package com.wow.petscore.medicalrecord.adpters.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetJpaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;

    private String petName;

    @Enumerated(value = EnumType.STRING)
    private PetType petType;

    @Enumerated(value = EnumType.STRING)
    private SizeType sizeType;

    @OneToOne(cascade = CascadeType.ALL)
    private MedicalRecordJpaEntity medicalRecord;

}
