package com.zDataAssignment.student_registration_system.service;
import com.zDataAssignment.student_registration_system.model.Registration;
import com.zDataAssignment.student_registration_system.exception.NotFoundException;
import com.zDataAssignment.student_registration_system.exception.ConflictException;
import com.zDataAssignment.student_registration_system.model.Course;
import com.zDataAssignment.student_registration_system.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private final Map <UUID, Student> studentMap;
    private final Map <UUID, Course> courseMap;
    private final List<Registration> registrations = new ArrayList<>();

    public RegistrationService(StudentService studentService, CourseService courseService) {
        this.studentMap = studentService.getStudentMap();
        this.courseMap = courseService.getCourseMap();
    }
    public void registerStudentToCourse(UUID studentId, UUID courseId){
        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseId);

        if (student == null) {
            throw new NotFoundException("Student not found with id: " + studentId);
        }
        if (course == null) {
            throw new NotFoundException("Course not found with id: " + courseId);
        }
        for (Registration registration : registrations) {
            if (registration.getStudentId().equals(studentId) &&
                    registration.getCourseId().equals(courseId)) {
                throw new ConflictException("Student is already registered for this course");
            }
        }
        Registration registration = new Registration(studentId, courseId, LocalDateTime.now());
        registrations.add(registration);
    }
    public void dropStudentFromCourse(UUID studentId, UUID courseId) {
        Registration registrationToRemove = null;

        for (Registration registration : registrations) {
            if (registration.getStudentId().equals(studentId) &&
                    registration.getCourseId().equals(courseId)) {
                registrationToRemove = registration;
                break;
            }
        }
        if (registrationToRemove == null) {
            throw new NotFoundException("Registration not found for studentId: " + studentId + " and courseId: " + courseId);
        }
        registrations.remove(registrationToRemove);
    }
    public List<Course>getRegisteredCourses(UUID studentID){
        if(!studentMap.containsKey(studentID)) {
            throw new NotFoundException("Student not found with id: " + studentID);
        }
        return registrations.stream()
                .filter(registration -> registration.getStudentId().equals(studentID))
                .map(registration -> courseMap.get(registration.getCourseId()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
