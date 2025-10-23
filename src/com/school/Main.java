package com.school;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("School Attendance Management — Part 08");

        // Create storage service
        FileStorageService storageService = new FileStorageService();
        
        // Create attendance service
        AttendanceService attendanceService = new AttendanceService(storageService);

        // Create sample students
        List<Student> allStudents = new ArrayList<>();
        Student sonali = new Student("Sonali", "10");
        Student charitha = new Student("Charitha", "11");
        allStudents.add(sonali);
        allStudents.add(charitha);

        // Create sample courses
        List<Course> allCourses = new ArrayList<>();
        Course dbms = new Course("DBMS");
        Course oops = new Course("OOPS");
        allCourses.add(dbms);
        allCourses.add(oops);

        // Mark attendance using different overloaded methods
        attendanceService.markAttendance(sonali, dbms, "Present");
        attendanceService.markAttendance(charitha, oops, "Present");
        attendanceService.markAttendance(1, 2, "Absent", allStudents, allCourses);

        // Display attendance using different overloaded methods
        System.out.println("\n--- Displaying Attendance Records ---");
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(sonali);
        attendanceService.displayAttendanceLog(dbms);

        // Save attendance data
        attendanceService.saveAttendanceData();
    }
}
