package com.dgsw.school.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enroll")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollEntity {

    @Id
    @Column(name = "school_id")
    private String schoolId;

    private String subject;
}