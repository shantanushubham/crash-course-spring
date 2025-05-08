package org.geeksforgeeks.crash_course_spring.service;

import org.geeksforgeeks.crash_course_spring.entities.Enrolment;
import org.geeksforgeeks.crash_course_spring.repository.EnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;

    @Autowired
    public EnrolmentService(EnrolmentRepository enrolmentRepository) {
        this.enrolmentRepository = enrolmentRepository;
    }

    public Enrolment addEnrolment(Enrolment enrolment) {
        if (enrolment.getEnrolmentDate().isAfter(enrolment.getCourse().getStartDate())) {
            // Throw an exception
        }
        if (this.enrolmentRepository.countByCourse(enrolment.getCourse()) + 1
                >= enrolment.getCourse().getCapacity()) {
            // throw an exception
        }
        return this.enrolmentRepository.save(enrolment);
    }
}
