package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private int courseId;
    private String courseName;

    private int capacity;    // NEW
    private List<Student> enrolledStudents; // NEW

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.courseId = nextCourseIdCounter++;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCapacity() { return capacity; }
    public int getNumberOfEnrolledStudents() { return enrolledStudents.size(); }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }

    // NEW: Enrollment logic
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    // Updated display
    public void displayDetails() {
        System.out.println(
            "Course: " + courseName +
            " (C" + courseId + "), Capacity: " + capacity +
            ", Enrolled: " + enrolledStudents.size()
        );
    }

    // Save: include capacity
    @Override
    public String toDataString() {
        return courseId + "," + courseName + "," + capacity;
    }
}
