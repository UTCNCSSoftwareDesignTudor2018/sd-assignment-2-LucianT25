package com.utcn.UTCN.Student.Platform.service;

import com.utcn.UTCN.Student.Platform.persistence.model.Course;
import com.utcn.UTCN.Student.Platform.persistence.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CourseService {

    @Inject
    CourseRepository courseRepository;

    public Course getCourse(int courseId) {
        return courseRepository.findCourseById(courseId);
    }
}
