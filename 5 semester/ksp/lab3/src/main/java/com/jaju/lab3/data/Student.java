package com.jaju.lab3.data;

import java.util.Objects;

public class Student {
    public static int counter = 0;

    private int id;
    private String fio;
    private String group;

    public Student(String fio, String group) {
        this.id = counter;
        counter++;
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
