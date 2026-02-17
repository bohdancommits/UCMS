package org.example.model.person;

import java.util.UUID;

public class Instructor extends Person{
    private String officeLocation;

    public Instructor(UUID personId, String name, String email, String officeLocation) {
        super(personId, name, email, PersonType.INSTRUCTOR);
        this.officeLocation = officeLocation;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    @Override
    public String getRoleDescription() {
        return "Instructor, Office: " + officeLocation;
    }

    @Override
    public String toString() {
        return super.toString() + " | Office: " + officeLocation;
    }
}
