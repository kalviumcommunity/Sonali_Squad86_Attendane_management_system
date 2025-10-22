package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Staff [ID: " + id + ", Name: " + name + ", Role: " + role + "]");
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + role;
    }
}
