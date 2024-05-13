package Collections;

import java.util.Set;
import java.util.TreeSet;

public class SortedStudentNamesTreeSet {
    public static void main(String[] args) {
        Set<String> studentNames = new TreeSet<>();
        studentNames.add("Alice");
        studentNames.add("John");
        studentNames.add("Emma");
        studentNames.add("David");
        studentNames.add("Sophia");
        System.out.println("Sorted Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
