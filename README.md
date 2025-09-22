# School Attendance System

This is a 10-part code-along project to build a comprehensive school attendance system using Java.

## Session 1: Introduction and Orientation

- Verified Java and Git setup.
- Initialized Git repository.
- Created basic project structure with `Main.java`.
- Successfully compiled and ran the initial application.

### How to Run

1. Compile using: javac src/com/school/Main.java
2. Run using: java -cp src com.school.Main

## Session 2: Core Domain Modelling
- Defined Student class with studentId, name, setDetails(), and displayDetails() method.
- Defined Course class with courseId, courseName, setDetails(), and displayDetails() method.
- Utilized arrays of objects in Main.java to manage and display multiple students and courses.
- Introduced basic usage of this keyword.

### How to Run
1. Navigate to the project root directory.
2. Compile: javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java (or javac src/com/school/*.java)
3. Run: java -cp src com.school.Main



## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in Student and Course classes for object initialization.
- Utilized private static member variables for automatic and unique ID generation.
- Demonstrated the use of the this keyword to distinguish instance variables from constructor parameters.
- Changed Course's courseId to int for simpler auto-generation and updated its display.
- Updated Main.java to use constructors and show ID progression.

### How to Run
1. Navigate to the project root directory.
2. Compile: javac src/com/school/*.java
3. Run: java -cp src com.school.Main


## Part 4 — Data Encapsulation & Attendance Recording Validation

What's new:
- Student and Course fields made private with public getters.
- New `AttendanceRecord` class with validation for status ("Present" / "Absent").
- Invalid statuses are normalized to "Invalid" and a warning is printed at creation.
- Demonstration in Main.java that constructs attendance records (including an invalid one) and prints the attendance log.

How to build & run:
1. javac -d out src/com/school/*.java
2. java -cp out com.school.Main


## Part 5 — Person inheritance hierarchy

Added:
- `Person` base class with centralized ID assignment and name.
- `Student`, `Teacher`, `Staff` classes extend `Person`.
- Student now has gradeLevel; Teacher has subject; Staff has staffRole.
- Main demonstrates creation and display of Students/Teachers/Staff and uses student.getId() for attendance.

Build & run:
1. javac -d out src/com/school/*.java
2. java -cp out com.school.Main

