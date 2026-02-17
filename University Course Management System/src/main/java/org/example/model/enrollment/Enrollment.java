package org.example.model.enrollment;

import java.time.LocalDateTime;
import java.util.UUID;

public class Enrollment {

    private UUID enrollmentId;
    private UUID studentId;
    private UUID courseId;
    private LocalDateTime enrollmentDate;
    private EnrollmentStatus status;
    private double grade;

    public Enrollment(UUID enrollmentId,
                      UUID studentId,
                      UUID courseId,
                      LocalDateTime enrollmentDate,
                      EnrollmentStatus status,
                      double grade) {

        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.grade = grade;
    }

    public UUID getEnrollmentId() {
        return enrollmentId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Enrollment " + enrollmentId +
                " | Status: " + status +
                " | Grade: " + grade;
    }
}

