package org.example.model.course;

import java.util.UUID;

public class OnlineCourse extends Course {
    private String platform;
    public OnlineCourse(UUID courseId, String courseCode, String title,
                        int credits, Department department, String platform){
        super(courseId,courseCode,title,credits,department);
        this.platform=platform;
    }
    public String getPlatform() {
        return platform;
    }
    @Override
    public double calculateTuition() {
        return getCredits() * 300;
    }
    @Override
    public String toString() {
        return "[Online] " + super.toString() +
                " | Platform: " + platform +
                " | Tuition: $" + calculateTuition();
    }
}
