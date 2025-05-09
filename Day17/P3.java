import java.util.*;
abstract class CourseType {
    public abstract String getEvaluationType();
}
class ExamCourse extends CourseType {
    public String getEvaluationType() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public String getEvaluationType() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public String getEvaluationType() {
        return "Research-Based Evaluation";
    }
}
class Course<T extends CourseType> {
    private String name;
    private T evaluation;

    public Course(String name, T evaluation) {
        this.name = name;
        this.evaluation = evaluation;
    }

    public String getDetails() {
        return name + " (" + evaluation.getEvaluationType() + ")";
    }
}
class CourseManager {
    public static void displayCourses(List<? extends CourseType> courseTypes) {
        for (CourseType ct : courseTypes) {
            System.out.println(ct.getEvaluationType());
        }
    }

    public static void displayGenericCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<?> course : courses) {
            System.out.println(course.getDetails());
        }
    }
}

public class P3 {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Math 101", new ExamCourse());
        Course<AssignmentCourse> writing = new Course<>("Creative Writing", new AssignmentCourse());
        Course<ResearchCourse> thesis = new Course<>("AI Thesis", new ResearchCourse());

        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        allCourses.add(math);
        allCourses.add(writing);
        allCourses.add(thesis);

        System.out.println("All Courses:");
        CourseManager.displayGenericCourses(allCourses);
    }
}
