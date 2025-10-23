package com.school;

public class AttendanceRecord implements Storable {
    private Person person;
    private Course course;
    private String status;

    public AttendanceRecord(Person person, Course course, String status) {
        this.person = person;
        this.course = course;
        if (status == null) status = "Invalid";
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            System.out.println("Warning: invalid attendance status '" + status + "' for " + person.getName() + ". Marked as Invalid.");
            this.status = "Invalid";
        }
    }

    public Person getPerson() { return person; }
    public Course getCourse() { return course; }
    public String getStatus() { return status; }
    public Student getStudent() { return (Student) person; }

    public void displayRecord() {
        System.out.println("Attendance → " + person.getName() + " (" + person.getId() + ") | Course: " + course.getCourseName() + " | Status: " + status);
    }

    @Override
    public String toDataString() {
        return person.getId() + "," + course.getCourseId() + "," + status;
    }

    @Override
    public String toString() {
        return "Attendance → " + person.getName() + " (" + person.getId() + ") | Course: " + course.getCourseName() + " | Status: " + status;
    }
}
