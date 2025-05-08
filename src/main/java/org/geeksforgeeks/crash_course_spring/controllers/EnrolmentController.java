package org.geeksforgeeks.crash_course_spring.controllers;

import jakarta.validation.Valid;
import org.geeksforgeeks.crash_course_spring.dto.EnrolmentDto;
import org.geeksforgeeks.crash_course_spring.entities.Enrolment;
import org.geeksforgeeks.crash_course_spring.mappers.EnrolmentMapper;
import org.geeksforgeeks.crash_course_spring.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrolment")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;
    private final EnrolmentMapper enrolmentMapper;

    @Autowired
    public EnrolmentController(EnrolmentService enrolmentService, EnrolmentMapper enrolmentMapper) {
        this.enrolmentService = enrolmentService;
        this.enrolmentMapper = enrolmentMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnrolment(@RequestBody EnrolmentDto enrolmentDto) {
        Enrolment enrolment = this.enrolmentMapper.mapToModel(enrolmentDto);
        return new ResponseEntity<>(this.enrolmentService.addEnrolment(enrolment), HttpStatus.CREATED);
    }
}
