package org.example.model.course;
import java.util.UUID;
public abstract class Course {
    private UUID courseId;
    private String courseCode;
    private String title;
    private int credits;
    private Department department;
    public Course(UUID courseId, String courseCode, String title, int credits, Department department) {
        this.courseId=courseId;
        this.courseCode=courseCode;
        this.title=title;
        this.credits=credits;
        this.department=department;
    }
    public UUID getCourseId() {
        return courseId;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getTitle() {
        return title;
    }
    public int getCredits() {
        return credits;
    }
    public Department getDepartment() {
        return department;
    }
    public abstract double calculateTuition();
    @Override
    public String toString() {
        return courseCode + " - " + title +
                " (" + credits + " credits, " + department + ")";
    }
}
