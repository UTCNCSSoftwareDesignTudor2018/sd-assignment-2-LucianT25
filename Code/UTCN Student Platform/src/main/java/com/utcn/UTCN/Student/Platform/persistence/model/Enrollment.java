package com.utcn.UTCN.Student.Platform.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="Enrollment")
public class Enrollment {

    @OneToOne
    @JoinColumn(name = "fk_student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "fk_course_id")
    private Course course;

    private double grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
