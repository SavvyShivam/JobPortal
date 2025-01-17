package com.job.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "recruiter_profile")
public class RecruiterProfile {
    @Id
    private int userAccountId;
    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String company;
    @Column(nullable = true,length = 64)
    private String profilePhoto;

    @Transient
    public String getPhotosImagePath(){
        if(profilePhoto==null) return null;
        return "/photos/recruiter/" + userAccountId + "/" + profilePhoto;
    }

    public RecruiterProfile (Users users){
        this.userId =users;
    }

}
