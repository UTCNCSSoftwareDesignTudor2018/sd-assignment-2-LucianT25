package com.utcn.UTCN.Student.Platform.persistence.model;

import java.util.List;

public class Report {
    private String id;
    private Student student;
    private List<Enrollment> enrollments;

    public Report(Student student, List<Enrollment> enrollments) {
        this.student = student;
        this.enrollments = enrollments;
    }

    public Report() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
