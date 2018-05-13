package com.utcn.UTCN.Student.Platform.persistence.repository;

import com.utcn.UTCN.Student.Platform.persistence.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
    List<Enrollment> findAllByStudentId(int studentId);
    List<Enrollment> findAllByTeacherId(int teacherId);
    List<Enrollment> findAllByStudentIdAndYear(int studentId, int year);
    Enrollment findByStudentIdAndTeacherId(int studentId, int teacherId);

}
