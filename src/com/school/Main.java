package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Attendance Management System!");

        // Create Students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Sonali", "10"));
        students.add(new Student("Charitha", "10"));
        students.add(new Student("Sravani", "11"));
        students.add(new Student("Sharon", "12"));

        // Teachers and staff (left in lists if needed elsewhere)
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Mr. Rao", "DBMS"));
        teachers.add(new Teacher("Ms. Anita", "OOPS"));

        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff("Mr. Kumar", "Clerk"));
        staffs.add(new Staff("Ms. Maya", "Librarian"));

        // Courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("DBMS"));
        courses.add(new Course("OOPS"));
        courses.add(new Course("Computer Networks"));

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

        // Attendance records
        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();
        // use getId() and getCourseId()
        attendanceLog.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students.get(2).getId(), courses.get(2).getCourseId(), "present"));
        attendanceLog.add(new AttendanceRecord(students.get(3).getId(), courses.get(0).getCourseId(), "On Leave")); // invalid

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }

        // Persist everything to files using FileStorageService
        FileStorageService storage = new FileStorageService();

        // Save students (id,name,grade)
        storage.saveData(students, "students.txt");

        // Save courses (courseId,courseName)
        storage.saveData(courses, "courses.txt");

        // Save attendance (studentId,courseId,status)
        storage.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nPersistence complete. Check students.txt, courses.txt, attendance_log.txt in the project root.");
    }
}
