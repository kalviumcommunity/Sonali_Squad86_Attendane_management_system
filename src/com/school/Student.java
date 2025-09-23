package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student, Grade: " + gradeLevel);
    }

    @Override
    public String toDataString() {
        // id,name,gradeLevel
        return id + "," + name + "," + gradeLevel;
    }
}
