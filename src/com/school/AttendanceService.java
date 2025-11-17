package com.school;

import java.util.*;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService; // NEW

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
        this.attendanceLog = new ArrayList<>();
    }

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Marked: " + student.getName());
    }

    // NEW — overloaded method using ID only
    public void markAttendance(int studentId, int courseId, String status) {
        Student s = registrationService.findStudentById(studentId);
        Course c = registrationService.findCourseById(courseId);

        if (s != null && c != null) {
            markAttendance(s, c, status);
        } else {
            System.out.println("❌ Invalid IDs");
        }
    }

    public void displayAttendanceLog() {
        System.out.println("\n=== Attendance Log ===");
        attendanceLog.forEach(AttendanceRecord::displayRecord);
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
