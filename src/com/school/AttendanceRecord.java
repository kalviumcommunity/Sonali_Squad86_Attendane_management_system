package com.school;

public class AttendanceRecord {
    private int studentId;
    private int courseId;
    private String status; // "Present", "Absent", or "Invalid"

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;

        if (status == null) {
            this.status = "Invalid";
            System.out.println("Warning: attendance status is null for student S" + studentId + " course C" + courseId + ". Marked as Invalid.");
        } else if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            // Normalize to Title case
            this.status = status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            this.status = "Invalid";
            System.out.println("Warning: invalid attendance status '" + status + "' for student S" + studentId + " course C" + courseId + ". Marked as Invalid.");
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Attendance - Student S" + studentId + ", Course C" + courseId + " : " + status);
    }
}
