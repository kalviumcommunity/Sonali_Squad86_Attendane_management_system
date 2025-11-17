package com.school;

public class Main {
    public static void main(String[] args) {

        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // --- Registration ---
        Student s1 = regService.registerStudent("Sonali", "10");
        Student s2 = regService.registerStudent("Rohit", "12");
        Teacher t1 = regService.registerTeacher("Mr. Rao", "DBMS");
        Staff st1 = regService.registerStaff("Kiran", "Admin");

        Course c1 = regService.createCourse("DBMS");
        Course c2 = regService.createCourse("OOPS");

        // --- Mark Attendance using IDs only ---
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Absent");

        // --- Display Directory ---
        System.out.println("\n=== School Directory ===");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
        }

        // --- Display Attendance ---
        attendanceService.displayAttendanceLog();

        // --- Save All Data Files ---
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }
}
