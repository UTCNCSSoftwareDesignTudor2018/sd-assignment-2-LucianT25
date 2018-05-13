package com.utcn.UTCN.Student.Platform.service;

import com.utcn.UTCN.Student.Platform.persistence.model.*;
import com.utcn.UTCN.Student.Platform.persistence.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class EnrollmentService {
    @Inject
    EnrollmentRepository enrollmentRepository;

    @Inject
    StudentService studentService;

    @Inject
    CourseService courseService;

    public List<Enrollment> getStudentEnrollments(int studentId) {
        return enrollmentRepository.findAllByStudentId(studentId);
    }

    public List<Enrollment> getStudentEnrollmentsByYear(int studentId, int year) {
        return enrollmentRepository.findAllByStudentIdAndYear(studentId, year);
    }

    public List<Enrollment> getTeacherEnrollments(int teacherId) {
        return enrollmentRepository.findAllByTeacherId(teacherId);
    }
    public void enroll(int courseId, int studentId) {
        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseId);
        Enrollment enrollment = new Enrollment(student, course);

        enrollmentRepository.save(enrollment);
    }

    public void update(EnrollmentToUpdate enrollmentToUpdate) {
        float grade = enrollmentToUpdate.getGrade();
        Enrollment enrollment = enrollmentRepository.findByStudentIdAndTeacherId(
                enrollmentToUpdate.getStudentId(), enrollmentToUpdate.getTeacherId());
        enrollment.setGrade(grade);
        enrollmentRepository.save(enrollment);
    }
}
