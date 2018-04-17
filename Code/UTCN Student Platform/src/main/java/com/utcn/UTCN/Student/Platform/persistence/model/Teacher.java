package com.utcn.UTCN.Student.Platform.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="Teacher")
public class Teacher extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private int id;
    private String name;
    private String address;
    private String email;

    @OneToOne
    @JoinColumn(name = "fk_course_id")
    private Course course;

    public Teacher(int id, String name, String address, String email, Course course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = course;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
