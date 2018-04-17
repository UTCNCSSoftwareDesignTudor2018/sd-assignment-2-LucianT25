package com.utcn.UTCN.Student.Platform.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private int id;
    private String name;
    private int year;
    private int credits;

    public Course() {
    }

    public Course(int id, String name, int year, int credits) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}

