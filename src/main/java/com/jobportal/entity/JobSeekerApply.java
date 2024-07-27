package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userId", "job"})
}, name = "job_seeker_apply")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobSeekerApply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date applyDate;

    private String coverLetter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job", referencedColumnName = "jobPostId")
    private JobPostActivity job;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName ="user_account_id")
    private JobSeekerProfile userId;
}
