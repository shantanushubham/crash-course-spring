package org.geeksforgeeks.crash_course_spring.repository;

import org.geeksforgeeks.crash_course_spring.entities.Course;
import org.geeksforgeeks.crash_course_spring.entities.Enrolment;
import org.geeksforgeeks.crash_course_spring.entities.Student;
import org.geeksforgeeks.crash_course_spring.enums.EnrolmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

    long countByCourse(Course course);

    List<Enrolment> findByStudent(Student student);

    List<Enrolment> findByStudentAndStatus(Student student, EnrolmentStatus status);

    // write a function that takes studentId as param and find all the enrollments for that student
}
