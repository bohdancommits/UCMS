package org.example.model.person;

import java.util.UUID;

public abstract class Person {
    private UUID personId;
    private String name;
    private String email;
    private PersonType personType;

    public Person(UUID personId, String name, String email, PersonType personType) {
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.personType = personType;
    }
    public UUID getPersonId() {
        return personId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public PersonType getPersonType() {
        return personType;
    }
    public abstract String getRoleDescription();
    @Override
    public String toString() {
        return name + " (" + personType + ")";
    }
}
