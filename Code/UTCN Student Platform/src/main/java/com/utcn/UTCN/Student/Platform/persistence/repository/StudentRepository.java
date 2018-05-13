package com.utcn.UTCN.Student.Platform.persistence.repository;

import com.utcn.UTCN.Student.Platform.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAll();
    Student findStudentById(int id);
}
