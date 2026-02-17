package org.example.model.course;
import java.util.UUID;
public class HybridCourse extends Course {
    private double onlinePercentage;
    public HybridCourse(UUID courseId, String courseCode, String title,
                        int credits, Department department, double onlinePercentage){
        super(courseId, courseCode, title, credits, department);
        this.onlinePercentage = onlinePercentage;

    }
    public double getOnlinePercentage() {
        return onlinePercentage;
    }
    @Override
    public double calculateTuition() {
        return getCredits() * 350;
    }
    @Override
    public String toString() {
        return "[Hybrid] " + super.toString() +
                " | Online: " + onlinePercentage + "%" +
                " | Tuition: $" + calculateTuition();
    }
}
