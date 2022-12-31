package com.hb07.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book07 {

    @Id
    private int id;


    private String name;


    @ManyToOne
    @JoinColumn
    private Student07 student;

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

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }
    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
