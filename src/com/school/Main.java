package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        Student[] students = {
            new Student("Sonali"),
            new Student("Charitha"),
            new Student("Sravani"),
            new Student("Sharon")
        };

        Course[] courses = {
            new Course("DBMS"),
            new Course("OOPS"),
            new Course("Computer Networks")
        };

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.displayDetails();
        }

        System.out.println("\n--- Course List ---");
        for (Course c : courses) {
            c.displayDetails();
        }
    }
}