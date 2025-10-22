package com.school;

public class Teacher extends Person implements Storable {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        System.out.println("Teacher [ID: " + id + ", Name: " + name + ", Subject: " + subject + "]");
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + subject;
    }
}
