package com.jaju.lab4.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String fio;

    @Column(name = "student_group")
    private String group;

    public Student(int id, String fio, String group) {
        this.id = id;
        this.fio = fio;
        this.group = group;
    }

    public Student() {
    }

    public Student(String fio, String group) {
        this.fio = fio;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(fio, student.fio) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, group);
    }
}
