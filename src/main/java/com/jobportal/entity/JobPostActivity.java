package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "job_post_activity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobPostActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int JobPostId;

    @Length(max = 10000)
    private String descriptionOfJob;

    private String jobTitle;

    private String jobType;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postedDate;

    private String remote;

    private String salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobCompanyId", referencedColumnName = "id")
    private JobCompany jobCompanyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobLocationId", referencedColumnName = "id")
    private JobLocation jobLocationId;

    @ManyToOne
    @JoinColumn(name = "postedById", referencedColumnName = "userId")
    private Users postedById;

    @Transient
    private boolean isActive;

    @Transient
    private boolean isSaved;
}