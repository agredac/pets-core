package com.wow.petscore.medicalrecord.adpters.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentJPAEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Lob
    private String description;

   @ManyToOne
   private MedicalRecordJpaEntity medicalRecord;

}
