# ZDATA-Registration-Backend
Student Course registration application backend using SpringBoot. 

To run the application, you need to have Java 17 installed on your machine.
## Prerequisites
- Java 17
- Maven
## Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/Nethsilu44/ZDATA-Registration-Backend.git 
   
2. Navigate to the project directory:
   ```bash

    cd ZDATA-Registration-Backend
    ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
   
4. Run the application:
   ```bash
    mvn spring-boot:run
    ```
   
5. The application will start running on `http://localhost:8080`.

##Sample API Endpoints
- **Register a student**: `POST http://localhost:8080/students`
- **Body {
  "name": "wishmith", "email": "wishmith123@gmail.com"
  }
- **Get all students**: `GET http://localhost:8080/students`
- **Get a student by ID**: `GET http://localhost:8080/students/{id}`
- **ADD a course**: `POST http://localhost:8080/courses`
- **Body{ "code": "CS101", "title": "Intro to CS", "instructor": "Dr. A" }
- **Get all courses**: `GET http://localhost:8080/courses`
- **Assign a course to a student**: `POST http://localhost:8080/students/{studentId}/courses/{courseId}`
- **Get courses for a student**: `GET http://localhost:8080/students/{studentId}/courses`

##Assumptions
- The application is designed for educational purposes and may not include all production-level features such as security, error handling, and validation.

##Code Structure explanation
- **Controllers**: Handle HTTP requests and responses.
         -**StudentController**: Manages student-related operations.
         -**CourseController**: Manages course-related operations.
         -**RegistrationController**: Manages course registration for students.
- 
- **Models**: Define the data structure for students and courses.
          - **Student**: Represents a student entity.
            - **Course**: Represents a course entity.
            - **Registration**: Represents the registration of a student for a course.

- **Services**: Contain the business logic for managing students and courses.
           - **StudentService**: Handles operations related to students.
              - **CourseService**: Handles operations related to courses.
              - **RegistrationService**: Manages the registration of students for courses.

- **Exceptions**: Handle custom exceptions and error responses.
             -**NotFoundException: Custom exception for not found resources.
             - **GlobalExceptionHandler**: Handles exceptions globally and returns appropriate error responses.
             - **ConflictException**: Custom exception for conflict errors.
             - **IllegalArgumentException**: Custom exception for illegal argument errors.

- **DTOs**: Data Transfer Objects for transferring data between layers.
           - StudentDTO: Data transfer object for student data.
              - CourseDTO: Data transfer object for course data.
            - RegistrationDTO: Data transfer object for registration data.

