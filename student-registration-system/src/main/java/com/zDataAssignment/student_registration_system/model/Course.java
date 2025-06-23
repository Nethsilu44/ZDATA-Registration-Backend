package com.zDataAssignment.student_registration_system.model;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public class Course {
    private UUID id;

    @NotBlank
    private String code;

    @NotBlank
    private String title;

    @NotBlank
    private String instructor;

    public Course(UUID id, String code, String title, String instructor) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.instructor = instructor;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

}
