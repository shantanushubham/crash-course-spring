package org.geeksforgeeks.crash_course_spring.service;

import org.geeksforgeeks.crash_course_spring.entities.Student;
import org.geeksforgeeks.crash_course_spring.exceptions.NotFoundException;
import org.geeksforgeeks.crash_course_spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student getStudentById(long studentId) {
        Optional<Student> optionalValue = this.studentRepository.findById(studentId);
        return optionalValue.orElseThrow(() -> new NotFoundException("Student with ID: " + studentId + " was not found."));
    }

    public Student updateStudent(Student student) {
        Student existingStudent = this.getStudentById(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);
    }
}
