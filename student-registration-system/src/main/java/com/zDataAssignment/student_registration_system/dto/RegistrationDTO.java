package com.zDataAssignment.student_registration_system.dto;


import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;


public class RegistrationDTO {

    @NotNull(message = "Student ID is required")
    private UUID courseID;

    @NotNull(message = "Course ID is required")
    private UUID studentID;

    @NotBlank(message = "Registration date is required")
    private String registrationDate;

    public RegistrationDTO(UUID courseID, UUID studentID, String registrationDate) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.registrationDate = registrationDate;
    }
    public UUID getCourseID() {
        return courseID;
    }
    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }
    public UUID getStudentID() {
        return studentID;
    }
    public void setStudentID(UUID studentID) {
        this.studentID = studentID;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
