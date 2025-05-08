package org.geeksforgeeks.crash_course_spring.controllers;

import jakarta.validation.Valid;
import org.geeksforgeeks.crash_course_spring.dto.CourseDto;
import org.geeksforgeeks.crash_course_spring.entities.Course;
import org.geeksforgeeks.crash_course_spring.mappers.CourseMapper;
import org.geeksforgeeks.crash_course_spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto courseDto) {
        Course course = this.courseMapper.mapToModel(courseDto);
        return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);
    }
}
