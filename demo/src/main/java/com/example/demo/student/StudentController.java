package com.example.demo.student;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/greet")
    public String greet() {
        return "HELLO USER";
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Object> registerNewStudent(@RequestBody Student student) {
        try {
            studentService.addNewStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body("Student added successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body("Failed to add student: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("studentId") Long studentId) {
        try {
            studentService.deleteStudent(studentId);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Student deleted successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete student: " + e.getMessage());
        }
    }
}
