package com.zDataAssignment.student_registration_system.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;



public class Student {
    private UUID id;

    @NotBlank
    private String name;

    @Email
    private String email;

    public Student(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
