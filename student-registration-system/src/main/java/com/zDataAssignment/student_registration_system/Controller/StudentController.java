package com.zDataAssignment.student_registration_system.Controller;

import com.zDataAssignment.student_registration_system.dto.StudentDTO;
import com.zDataAssignment.student_registration_system.model.Registration;
import com.zDataAssignment.student_registration_system.model.Student;
import com.zDataAssignment.student_registration_system.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    @PostMapping("/{id}/register/{courseId}")
    public ResponseEntity<String> registerStudentToCourse(@PathVariable UUID id, @PathVariable UUID courseId) {
        return new ResponseEntity<>("Registration feature not implemented yet", HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        Collection<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable UUID id) {
        Student student = studentService.getStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @DeleteMapping("/{id}/drop/{courseId}")
    public ResponseEntity<String> dropStudentFromCourse(@PathVariable UUID id, @PathVariable UUID courseId) {
        return new ResponseEntity<>("Drop feature not implemented yet", HttpStatus.NOT_IMPLEMENTED);
    }


}
