package org.geeksforgeeks.crash_course_spring.service;

import org.geeksforgeeks.crash_course_spring.entities.Course;
import org.geeksforgeeks.crash_course_spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    }

    public Course getCourseById(long courseId) {
        return this.courseRepository.findById(courseId).orElse(null);
    }
}
