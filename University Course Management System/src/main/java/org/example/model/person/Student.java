package org.example.model.person;

import java.util.UUID;

public class Student extends Person{
    private String major;

    public Student(UUID personId, String name, String email, String major) {
        super(personId, name, email, PersonType.STUDENT);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String getRoleDescription() {
        return "Student majoring in " + major;
    }

    @Override
    public String toString() {
        return super.toString() + " | Major: " + major;
    }
}
