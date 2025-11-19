package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
    }

    // ===========================
    //   STUDENT / TEACHER / STAFF REGISTRATION
    // ===========================

    public Student registerStudent(String name, String grade) {
        Student student = new Student(name, grade);
        students.add(student);
        System.out.println("Registered Student: " + name);
        return student;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher teacher = new Teacher(name, subject);
        teachers.add(teacher);
        System.out.println("Registered Teacher: " + name);
        return teacher;
    }

    public Staff registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
        System.out.println("Registered Staff: " + name);
        return staff;
    }

    // ===========================
    //   COURSE CREATION (WITH CAPACITY)
    // ===========================

    public Course createCourse(String courseName, int capacity) {
        Course course = new Course(courseName, capacity);
        courses.add(course);
        System.out.println("Created Course: " + courseName + " (Capacity: " + capacity + ")");
        return course;
    }

    // ===========================
    //   ENROLLMENT
    // ===========================

    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);

        if (success) {
            System.out.println("✔ Enrolled " + student.getName() +
                               " into " + course.getCourseName());
        } else {
            System.out.println("❌ Could NOT enroll " + student.getName() +
                               ". Course '" + course.getCourseName() + "' is FULL!");
        }

        return success;
    }

    // ===========================
    //   LOOKUP METHODS
    // ===========================

    public Student findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Teacher findTeacherById(int id) {
        return teachers.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Staff findStaffById(int id) {
        return staffMembers.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    // ===========================
    //   GETTER METHODS
    // ===========================

    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    public List<Person> getAllPeople() {
        List<Person> combined = new ArrayList<>();
        combined.addAll(students);
        combined.addAll(teachers);
        combined.addAll(staffMembers);
        return combined;
    }

    // ===========================
    //   SAVE ALL REGISTRATION DATA
    // ===========================

    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
        System.out.println("✔ All registration data saved!");
    }
}
