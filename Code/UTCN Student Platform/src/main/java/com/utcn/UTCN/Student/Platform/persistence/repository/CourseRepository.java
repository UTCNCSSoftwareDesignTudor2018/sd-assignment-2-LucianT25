package com.utcn.UTCN.Student.Platform.persistence.repository;

import com.utcn.UTCN.Student.Platform.persistence.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
    Course findCourseById(int id);
}
