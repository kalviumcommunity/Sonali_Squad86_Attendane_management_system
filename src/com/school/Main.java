package com.school;

public class Main {
    public static void main(String[] args) {

        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // ---- REGISTER STUDENTS ----
        Student s1 = regService.registerStudent("Sonali", "10");
        Student s2 = regService.registerStudent("Rohit", "12");
        Student s3 = regService.registerStudent("Charitha", "11");

        // ---- CREATE COURSES WITH CAPACITY ----
        Course c1 = regService.createCourse("DBMS", 2);
        Course c2 = regService.createCourse("OOPS", 1);

        // ---- ENROLLMENT (including max-capacity test) ----
        regService.enrollStudentInCourse(s1, c1);
        regService.enrollStudentInCourse(s2, c1);
        regService.enrollStudentInCourse(s3, c1); // ❌ should exceed capacity

        regService.enrollStudentInCourse(s1, c2);
        regService.enrollStudentInCourse(s2, c2); // ❌ should exceed capacity

        // ---- DISPLAY COURSE DETAILS ----
        System.out.println("\n=== Course Details ===");
        c1.displayDetails();
        c2.displayDetails();

        // OPTIONAL: Attendance only for enrolled students
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c1.getCourseId(), "Absent");

        System.out.println("\n=== Attendance Log ===");
        attendanceService.displayAttendanceLog();

        // ---- SAVE ALL FILES ----
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
