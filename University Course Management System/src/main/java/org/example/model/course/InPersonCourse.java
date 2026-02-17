package org.example.model.course;
import java.util.UUID;
public class InPersonCourse extends Course {
    private String roomNumber;
    public InPersonCourse(UUID courseId, String courseCode, String title,
                          int credits, Department department, String roomNumber){
        super(courseId, courseCode, title, credits, department);
        this.roomNumber = roomNumber;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    @Override
    public double calculateTuition() {
        return getCredits() * 400;
    }
    @Override
    public String toString(){
        return "[In-Person] " + super.toString() +
                " | Room: " + roomNumber +
                " | Tuition: $" + calculateTuition();
    }

}
