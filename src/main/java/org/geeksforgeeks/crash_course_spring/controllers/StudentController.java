package org.geeksforgeeks.crash_course_spring.controllers;

import jakarta.validation.Valid;
import org.geeksforgeeks.crash_course_spring.entities.Student;
import org.geeksforgeeks.crash_course_spring.exceptions.NotFoundException;
import org.geeksforgeeks.crash_course_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student) {
        try {
            return ResponseEntity.ok(this.studentService.addStudent(student));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{sId}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "sId") long studentId) {
        try {
            Student student =  this.studentService.getStudentById(studentId);
            return ResponseEntity.ok(student);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable long studentId, @RequestBody @Valid Student student) {
        try {
            if (studentId != student.getId()) {
                return ResponseEntity.badRequest().body(Map.of("message", "The ID in the path and the body are not same."));
            }
            Student updatedStudent = this.studentService.updateStudent(student);
            return ResponseEntity.ok(updatedStudent);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable long studentId) {
        try {
            this.studentService.deleteStudentById(studentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}
