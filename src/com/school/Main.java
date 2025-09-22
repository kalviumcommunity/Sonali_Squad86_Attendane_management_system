package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        // Create Persons (Students now have grade)
        Student[] students = {
            new Student("Sonali", "10"),
            new Student("Charitha", "10"),
            new Student("Sravani", "11"),
            new Student("Sharon", "12")
        };

        // Teachers and staff
        Teacher[] teachers = {
            new Teacher("Mr. Rao", "DBMS"),
            new Teacher("Ms. Anita", "OOPS")
        };

        Staff[] staffs = {
            new Staff("Mr. Kumar", "Clerk"),
            new Staff("Ms. Maya", "Librarian")
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

        System.out.println("\n--- Teacher List ---");
        for (Teacher t : teachers) {
            t.displayDetails();
        }

        System.out.println("\n--- Staff List ---");
        for (Staff st : staffs) {
            st.displayDetails();
        }

        System.out.println("\n--- Course List ---");
        for (Course c : courses) {
            c.displayDetails();
        }

        // --- Attendance recording (uses student.getId()) ---
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "present"));
        attendanceLog.add(new AttendanceRecord(students[3].getId(), courses[0].getCourseId(), "On Leave")); // invalid

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }
}
