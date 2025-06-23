package com.zDataAssignment.student_registration_system.Controller;

import com.zDataAssignment.student_registration_system.model.Course;
import com.zDataAssignment.student_registration_system.model.Registration;
import com.zDataAssignment.student_registration_system.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registrations")

public class RegistrationController {
        private final RegistrationService registrationService;

        public RegistrationController(RegistrationService registrationService) {
            this.registrationService = registrationService;
        }

        // POST /registrations/{studentId}/courses/{courseId}
        @PostMapping("/{studentId}/courses/{courseId}")
        public ResponseEntity<String> registerStudentToCourse(
                @PathVariable UUID studentId,
                @PathVariable UUID courseId) {

            registrationService.registerStudentToCourse(studentId, courseId);
            return new ResponseEntity<>("Student registered to course successfully", HttpStatus.CREATED);
        }

        // DELETE /registrations/{studentId}/courses/{courseId}
        @DeleteMapping("/{studentId}/courses/{courseId}")
        public ResponseEntity<String> dropStudentFromCourse(
                @PathVariable UUID studentId,
                @PathVariable UUID courseId) {

            registrationService.dropStudentFromCourse(studentId, courseId);
            return new ResponseEntity<>("Student dropped from course successfully", HttpStatus.OK);
        }
        // GET /registrations/{studentId}/courses
        @GetMapping("/{studentId}/courses")
        public ResponseEntity<List<Course>> getRegisteredCourses(@PathVariable UUID studentId) {
            List<Course> registeredCourses = registrationService.getRegisteredCourses(studentId);
            return new ResponseEntity<>(registeredCourses, HttpStatus.OK);
        }
}
