package com.utcn.UTCN.Student.Platform.persistence.repository.Impl;

import com.utcn.UTCN.Student.Platform.persistence.model.Student;
import com.utcn.UTCN.Student.Platform.persistence.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> findAllStudents() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = builder.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }
}
