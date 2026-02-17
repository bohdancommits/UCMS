package org.example.controller;

import org.example.model.course.Course;
import org.example.model.course.Department;
import org.example.model.enrollment.Enrollment;
import org.example.model.person.Person;
import org.example.util.Console;
//import org.example.model.course.Course;
//import org.example.model.course.Department;
import org.example.model.course.OnlineCourse;
import org.example.model.course.InPersonCourse;
import org.example.model.course.HybridCourse;

//import org.example.model.people.Person;
import org.example.model.person.Student;
import org.example.model.person.Instructor;
import org.example.model.person.PersonType;

//import org.example.model.enrollment.Enrollment;
import org.example.model.enrollment.EnrollmentStatus;

import org.example.util.Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * UniversitySystem
 *
 * This class acts as the main controller for the application.
 * It is responsible for:
 *  - Reading data from CSV files
 *  - Creating objects using inheritance and polymorphism
 *  - Storing records in collections
 *  - Displaying a menu-driven console interface
 *
 * IMPORTANT:
 * Students should NOT modify this class unless instructed.
 */
public class UniversitySystem {

    // Collections to store system records
    private final List<Course> courses = new ArrayList<>();
    private final List<Person> people = new ArrayList<>();
    private final List<Enrollment> enrollments = new ArrayList<>();

    /**
     * Entry point for running the system.
     * This method loads data, displays the menu,
     * and handles user interaction.
     */
    public void run() {
        loadCourses();
        loadPeople();
        loadEnrollments();

        System.out.println("========================================");
        System.out.println(" Welcome to the University System ");
        System.out.println("========================================");

        int choice;
        do {
            printMenu();
            choice = Console.getInt("Choose an option: ");

            switch (choice) {
                case 1 -> printCourses();
                case 2 -> printPeople();
                case 3 -> printEnrollments();
                case 4 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);
    }

    /**
     * Prints the main menu options.
     */
    private void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. View all courses");
        System.out.println("2. View all people");
        System.out.println("3. View all enrollments");
        System.out.println("4. Exit");
    }

    // =========================================================
    // COURSE LOADING
    // =========================================================

    /**
     * Reads course records from courses.csv
     * and creates appropriate Course objects.
     */
    private void loadCourses() {
        try (Scanner scanner = new Scanner(new File("files/courses.csv"))) {

            scanner.nextLine(); // skip header row

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");

                UUID courseId = UUID.fromString(parts[0]);
                String courseType = parts[1];
                String courseCode = parts[2];
                String title = parts[3];
                int credits = Integer.parseInt(parts[4]);
                Department department = Department.valueOf(parts[5]);
                String extra = parts[6];

                Course course;

                // Polymorphic object creation
                switch (courseType) {
                    case "ONLINE" ->
                            course = new OnlineCourse(courseId, courseCode, title,
                                    credits, department, extra);

                    case "INPERSON" ->
                            course = new InPersonCourse(courseId, courseCode, title,
                                    credits, department, extra);

                    case "HYBRID" ->
                            course = new HybridCourse(courseId, courseCode, title,
                                    credits, department, Double.parseDouble(extra));

                    default -> throw new IllegalArgumentException("Unknown course type");
                }

                courses.add(course);
            }

        } catch (FileNotFoundException e) {
            System.out.println("courses.csv not found.");
        }
    }

    // =========================================================
    // PEOPLE LOADING
    // =========================================================

    /**
     * Reads person records from people.csv
     * and creates Student or Instructor objects.
     */
    private void loadPeople() {
        try (Scanner scanner = new Scanner(new File("files/people.csv"))) {

            scanner.nextLine(); // skip header row

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");

                UUID personId = UUID.fromString(parts[0]);
                PersonType type = PersonType.valueOf(parts[1]);
                String name = parts[2];
                String email = parts[3];
                String extra = parts[4];

                Person person;

                // Polymorphic object creation
                if (type == PersonType.STUDENT) {
                    person = new Student(personId, name, email, extra);
                } else {
                    person = new Instructor(personId, name, email, extra);
                }

                people.add(person);
            }

        } catch (FileNotFoundException e) {
            System.out.println("people.csv not found.");
        }
    }

    // =========================================================
    // ENROLLMENT LOADING
    // =========================================================

    /**
     * Reads enrollment records from enrollments.csv
     * and creates Enrollment objects.
     */
    private void loadEnrollments() {
        try (Scanner scanner = new Scanner(new File("files/enrollments.csv"))) {

            scanner.nextLine(); // skip header row

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");

                UUID enrollmentId = UUID.fromString(parts[0]);
                UUID studentId = UUID.fromString(parts[1]);
                UUID courseId = UUID.fromString(parts[2]);
                LocalDateTime date = LocalDateTime.parse(parts[3]);
                EnrollmentStatus status = EnrollmentStatus.valueOf(parts[4]);
                double grade = Double.parseDouble(parts[5]);

                Enrollment enrollment = new Enrollment(
                        enrollmentId,
                        studentId,
                        courseId,
                        date,
                        status,
                        grade
                );

                enrollments.add(enrollment);
            }

        } catch (FileNotFoundException e) {
            System.out.println("enrollments.csv not found.");
        }
    }

    // =========================================================
    // PRINT METHODS
    // =========================================================

    /**
     * Prints all course records.
     */
    private void printCourses() {
        System.out.println("\n--- Course Records ---");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    /**
     * Prints all people records.
     */
    private void printPeople() {
        System.out.println("\n--- People Records ---");
        for (Person person : people) {
            System.out.println(person + " | " + person.getRoleDescription());
        }
    }

    /**
     * Prints all enrollment records.
     */
    private void printEnrollments() {
        System.out.println("\n--- Enrollment Records ---");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}