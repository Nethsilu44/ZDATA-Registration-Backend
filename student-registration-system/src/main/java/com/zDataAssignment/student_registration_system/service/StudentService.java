package com.zDataAssignment.student_registration_system.service;

import com.zDataAssignment.student_registration_system.exception.ConflictException;
import com.zDataAssignment.student_registration_system.exception.NotFoundException;
import org.springframework.stereotype.Service;
import com.zDataAssignment.student_registration_system.dto.StudentDTO;
import com.zDataAssignment.student_registration_system.model.Student;
import com.zDataAssignment.student_registration_system.model.Course;
import com.zDataAssignment.student_registration_system.model.Registration;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class StudentService {
    private final Map<UUID, Student> studentMap = new HashMap<>();
    private final Map<UUID, Course> courseMap = new HashMap<>();
    private final List<Registration> registrationList = new ArrayList<>();

    public Student createStudent(StudentDTO studentDTO){
        for(Student student : studentMap.values()) {
            if (student.getEmail().equals(studentDTO.getEmail())) {
                throw new ConflictException("Email already exists");
            }
        }
        if (studentDTO.getName() == null || studentDTO.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        Student student = new Student(UUID.randomUUID(), studentDTO.getName(), studentDTO.getEmail());
        studentMap.put(student.getId(), student);
        return student;
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    public Student getStudent(UUID id){
        Student s = studentMap.get(id);
        if (s == null) {
            throw new NotFoundException("Student not found with id: " + id);
        }
            return s;
        }

    public void registerStudentToCourse(UUID studentId, UUID courseId) {
        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseId);

        if (student == null) {
            throw new NotFoundException("Student not found with id: " + studentId);
        }
        if (course == null) {
            throw new NotFoundException("Course not found with id: " + courseId);
        }
        for (Registration registration : registrationList) {
            if (registration.getStudentId().equals(studentId) &&
                    registration.getCourseId().equals(courseId)) {
                throw new ConflictException("Student is already registered for this course");
            }
        }
        Registration registration = new Registration(studentId, courseId, LocalDateTime.now());
        registrationList.add(registration);

        }
        public void dropStudentFromCourse(UUID studentId, UUID courseId) {
            Registration registrationToRemove = null;
            for (Registration registration : registrationList) {
                if (registration.getStudentId().equals(studentId) &&
                        registration.getCourseId().equals(courseId)) {
                    registrationToRemove = registration;
                    break;
                }
            }
            if (registrationToRemove == null) {
                throw new NotFoundException("No registration found for student with id: " + studentId + " and course with id: " + courseId);
            }
            registrationList.remove(registrationToRemove);
        }

        public List<Course> getRegisteredCourses(UUID studentId) {
            List<Course> registeredCourses = new ArrayList<>();
            for (Registration registration : registrationList) {
                if (registration.getStudentId().equals(studentId)) {
                    Course course = courseMap.get(registration.getCourseId());
                    if (course != null) {
                        registeredCourses.add(course);
                    }
                }
            }
            return registeredCourses;
        }
        public void addCourse(Course course) {
            for (Course existingCourse : courseMap.values()) {
                if (existingCourse.getCode().equalsIgnoreCase(course.getCode())) {
                    throw new ConflictException("Course code already exists.");
                }
            }

            courseMap.put(course.getId(), course);
        }
    public Collection<Course> getAllCourses() {
        return courseMap.values();
    }

    public Map<UUID, Student> getStudentMap() {
        return studentMap;
    }
}


