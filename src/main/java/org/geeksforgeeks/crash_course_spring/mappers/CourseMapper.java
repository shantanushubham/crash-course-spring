package org.geeksforgeeks.crash_course_spring.mappers;

import org.geeksforgeeks.crash_course_spring.dto.CourseDto;
import org.geeksforgeeks.crash_course_spring.entities.Course;
import org.geeksforgeeks.crash_course_spring.entities.Mentor;
import org.geeksforgeeks.crash_course_spring.exceptions.NotFoundException;
import org.geeksforgeeks.crash_course_spring.repository.CourseRepository;
import org.geeksforgeeks.crash_course_spring.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    private final MentorRepository mentorRepository;

    @Autowired
    public CourseMapper(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Course mapToModel(CourseDto dto) {
        Course course = new Course();
        Mentor mentor = this.mentorRepository.findById(dto.getMentorId()).orElseThrow(() ->  new NotFoundException("Cannot find mentor with ID: " + dto.getMentorId()));
        course.setName(dto.getName());
        course.setPrice(dto.getPrice());
        course.setCapacity(dto.getCapacity());
        course.setNoOfDays(dto.getNoOfDays());
        course.setStartDate(dto.getStartDate());
        course.setDescription(dto.getDescription());
        course.setMentor(mentor);
        course.setEnrolmentEndDate(dto.getEnrolmentEndDate());
        return course;
    }
}
