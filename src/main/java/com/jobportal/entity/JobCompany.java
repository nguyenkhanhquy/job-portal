package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String logo;

    private String name;
}
