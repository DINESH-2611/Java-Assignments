package Collections;

import java.util.Map;
import java.util.TreeMap;

public class StudentGradeTreeMap {
    public static void main(String[] args) {
        Map<String, Integer> studentGrades = new TreeMap<>();

        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);
        studentGrades.put("David", 95);

        int gradeOfBob = studentGrades.get("Bob");
        System.out.println("Grade of Bob: " + gradeOfBob);

        System.out.println("Student Grades:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Grade: " + entry.getValue());
        }
    }
}
