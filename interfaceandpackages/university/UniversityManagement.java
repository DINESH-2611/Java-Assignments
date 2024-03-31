package interfaceandpackages.university;

import interfaceandpackages.university.courses.Course;
import interfaceandpackages.university.faculty.Faculty;
import interfaceandpackages.university.students.Student;

public class UniversityManagement {
    public static void main(String[] args) {
        new UniversityManagement().init();
    }

    private void init() {
        Student student=new Student("Jack","jack@gmail.com",9182736450l,"UNI20241");
        Faculty faculty=new Faculty("Kumar","kumar@gmail.com",123456789,"FAC123");
        Course course=new Course("Java","J777");
        System.out.println(student);
        System.out.println(faculty);
        System.out.println(course);
    }
}
