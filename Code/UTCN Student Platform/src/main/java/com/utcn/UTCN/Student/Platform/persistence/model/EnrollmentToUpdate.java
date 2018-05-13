package com.utcn.UTCN.Student.Platform.persistence.model;

public class EnrollmentToUpdate {
    int studentId;
    int teacherId;
    float grade;

    public EnrollmentToUpdate(int studentId, int teacherId, float grade) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
