package com.utcn.UTCN.Student.Platform.persistence.repository;

import com.utcn.UTCN.Student.Platform.persistence.model.Student;

import java.util.List;

public interface IStudentRepository {
    void insertStudent(Student student);

    List<Student> findAllStudents();
}
