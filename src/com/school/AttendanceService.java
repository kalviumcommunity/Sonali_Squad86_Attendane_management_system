package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
        
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Student or Course not found!");
        }
    }

    private Student findStudentById(int studentId, List<Student> allStudents) {
        return allStudents.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElse(null);
    }

    private Course findCourseById(int courseId, List<Course> allCourses) {
        return allCourses.stream()
                .filter(course -> course.getId() == courseId)
                .findFirst()
                .orElse(null);
    }

    public void displayAttendanceLog() {
        System.out.println("\nAll Attendance Records:");
        attendanceLog.forEach(System.out::println);
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\nAttendance Records for student: " + student.getName());
        attendanceLog.stream()
                .filter(record -> record.getStudent().equals(student))
                .forEach(System.out::println);
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\nAttendance Records for course: " + course.getName());
        attendanceLog.stream()
                .filter(record -> record.getCourse().equals(course))
                .forEach(System.out::println);
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}