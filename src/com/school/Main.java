package com.school;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("School Attendance Management — Part 07");

        List<Person> directory = new ArrayList<>();
        directory.add(new Student("Sonali", "10"));
        directory.add(new Student("Charitha", "11"));
        directory.add(new Teacher("Mr. Rao", "DBMS"));
        directory.add(new Staff("Ms. Maya", "Librarian"));

        System.out.println("\n--- School Directory ---");
        for (Person p : directory) {
            p.displayDetails(); // runtime polymorphism
        }

        Course dbms = new Course("DBMS");
        Course oops = new Course("OOPS");

        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(directory.get(0), dbms, "Present"));
        attendanceLog.add(new AttendanceRecord(directory.get(1), dbms, "Absent"));
        attendanceLog.add(new AttendanceRecord(directory.get(2), oops, "Present"));
        attendanceLog.add(new AttendanceRecord(directory.get(3), oops, "On Leave")); // show invalid

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
        }
    }
}
