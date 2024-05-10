package com.CSE.DepartmentApplicationService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserData {

    @Id
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String phoneNumber;
    private String zNumber;
    private String email;
    private String dateOfBirth;
    private String courses;
    private String previouslyTa;
    private String taStartDate;
    private String taEndDate;
    private String resume;
    private String gpa;
    private String status1;
    private String assignTask;
    private String assignTaskDone;
    private String status2;
    private String status3;
    private String commentedByInstructor;
    private String selectedOrRejected;
    private String acceptOrRejectOffer;
}
