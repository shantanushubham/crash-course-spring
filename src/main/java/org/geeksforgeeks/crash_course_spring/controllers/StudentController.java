package org.geeksforgeeks.crash_course_spring.controllers;

import org.geeksforgeeks.crash_course_spring.entities.Student;
import org.geeksforgeeks.crash_course_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/student/{sId}")
    public Student getStudentById(@PathVariable(name = "sId") long studentId) {
        return this.studentService.getStudentById(studentId);
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable long studentId, @RequestBody Student student) {
        if (studentId != student.getId()) {
            // Throw some error
        }
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable long studentId) {
        this.studentService.deleteStudentById(studentId);
    }
}
