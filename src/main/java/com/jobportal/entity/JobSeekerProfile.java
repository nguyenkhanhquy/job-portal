package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "job_seeker_profile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobSeekerProfile {

    @Id
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String city;

    private String country;

    private String employmentType;

    private String firstName;

    private String lastName;

    @Column(nullable = false, length = 64)
    private String profilePhoto;

    private String resume;

    private String state;

    private String workAuthorization;

    @OneToMany(targetEntity = Skills.class, mappedBy = "jobSeekerProfile", cascade = CascadeType.ALL)
    private List<Skills> skills;

    public JobSeekerProfile(Users user) {
        this.userId = user;
    }
}
