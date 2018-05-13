package com.utcn.UTCN.Student.Platform.service;

import com.utcn.UTCN.Student.Platform.persistence.model.Student;
import com.utcn.UTCN.Student.Platform.persistence.model.StudentToUpdate;
import com.utcn.UTCN.Student.Platform.persistence.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class StudentService {
    @Inject
    StudentRepository studentRepository;

    public Student getStudent(int id) {
        return studentRepository.findStudentById(id);
    }

    public void update(StudentToUpdate studentToUpdate) {
        Student student = studentRepository.findStudentById(studentToUpdate.getId());

        student.setName(studentToUpdate.getName());
        student.setAddress(studentToUpdate.getAddress());
        student.setEmail(studentToUpdate.getEmail());

        studentRepository.save(student);
    }
}
