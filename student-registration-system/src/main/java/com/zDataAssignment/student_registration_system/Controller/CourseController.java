package com.zDataAssignment.student_registration_system.Controller;

import com.zDataAssignment.student_registration_system.model.Course;
import com.zDataAssignment.student_registration_system.dto.CourseDTO;
import com.zDataAssignment.student_registration_system.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        Course createdCourse = courseService.createCourse(courseDTO);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
}
