package com.utcn.UTCN.Student.Platform.persistence.model;

public class ReportToGenerate {
    private int studentId;
    private int year;

    public ReportToGenerate(int studentId, int year) {
        this.studentId = studentId;
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
