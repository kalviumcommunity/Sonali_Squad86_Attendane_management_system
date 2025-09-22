package com.school;

import java.util.ArrayList;
import java.util.List;

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

        // --- Attendance recording (Part 4) ---
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Valid entries
        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(), courses[1].getCourseId(), "Absent"));

        // Case-insensitive valid
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(), courses[2].getCourseId(), "present"));

        // Invalid entry to test validation
        attendanceLog.add(new AttendanceRecord(students[3].getStudentId(), courses[0].getCourseId(), "On Leave"));

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }
}
