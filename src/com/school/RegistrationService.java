package com.school;

import java.util.*;

public class RegistrationService {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
    }

    // --- Register Methods ---
    public Student registerStudent(String name, String grade) {
        Student s = new Student(name, grade);
        students.add(s);
        return s;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher t = new Teacher(name, subject);
        teachers.add(t);
        return t;
    }

    public Staff registerStaff(String name, String role) {
        Staff st = new Staff(name, role);
        staffMembers.add(st);
        return st;
    }

    public Course createCourse(String name) {
        Course c = new Course(name);
        courses.add(c);
        return c;
    }

    // --- Getters ---
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    // --- Lookup Methods ---
    public Student findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream().filter(c -> c.getCourseId() == id).findFirst().orElse(null);
    }

    // --- Combined People List ---
    public List<Person> getAllPeople() {
        List<Person> result = new ArrayList<>();
        result.addAll(students);
        result.addAll(teachers);
        result.addAll(staffMembers);
        return result;
    }

    // --- Save All Registrations ---
    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
        System.out.println("Registration saved.");
    }
}
