package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String country;

    private String state;
}
