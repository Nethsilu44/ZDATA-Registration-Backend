package com.zDataAssignment.student_registration_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class StudentDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    public StudentDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
