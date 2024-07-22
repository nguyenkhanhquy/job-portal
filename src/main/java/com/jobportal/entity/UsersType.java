package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeId;

    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "userTypeId" , cascade = CascadeType.ALL)
    private List<Users> users;

    // Only select these two entries
    // This will avoid recursive toString() issue with UsersType <-> Users
    @Override
    public String toString() {
        return "UsersType{" +
                "userTypeName='" + userTypeName + '\'' +
                ", userTypeId=" + userTypeId +
                '}';
    }
}
