package com.zDataAssignment.student_registration_system.service;

import com.zDataAssignment.student_registration_system.exception.ConflictException;
import com.zDataAssignment.student_registration_system.exception.NotFoundException;
import org.springframework.stereotype.Service;
import com.zDataAssignment.student_registration_system.dto.CourseDTO;
import com.zDataAssignment.student_registration_system.model.Course;

import java.util.*;

@Service
public class CourseService {
    private final Map<UUID, Course> courseMap = new HashMap<>();

    public Course createCourse(CourseDTO courseDTO) {
        for (Course course : courseMap.values()) {
            if (course.getCode().equals(courseDTO.getCode())) {
                throw new ConflictException("Course code already exists");
            }
        }
        if (courseDTO.getTitle() == null || courseDTO.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        Course course = new Course(UUID.randomUUID(), courseDTO.getCode(), courseDTO.getTitle(), courseDTO.getInstructor());
        courseMap.put(course.getId(), course);
        return course;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public Course getCourseById(UUID id) {
        Course c = courseMap.get(id);
        if (c == null) {
            throw new NotFoundException("Course not found with id: " + id);
        }
        return c;
    }
    //expose internal map to StudentService
    public Map<UUID, Course> getCourseMap() {
        return courseMap;
    }

}
