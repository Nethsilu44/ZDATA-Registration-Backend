package com.zDataAssignment.student_registration_system.dto;


import jakarta.validation.constraints.NotBlank;


public class CourseDTO {
    @NotBlank(message = "Course code is required")
    private String code;

    @NotBlank(message = "Course title is required")
    private String title;

    @NotBlank(message = "Instructor name is required")
    private String instructor;

    public CourseDTO(String code, String title, String instructor) {
        this.code = code;
        this.title = title;
        this.instructor = instructor;
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
