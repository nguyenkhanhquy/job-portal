package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruiter_profile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RecruiterProfile {

    @Id
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String city;

    private String company;

    private String country;

    private String firstName;

    private String lastName;

    @Column(nullable = false, length = 64)
    private String profilePhoto;

    private String state;
}
