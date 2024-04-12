package arraylist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Student {
    int rollNo;
    String name;
    double marks;
    Date dob;

    public Student(int rollNo, String name, double marks, Date dob) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.dob = dob;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public Date getDob() {
        return dob;
    }
}

class RollNoComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        if (s1.rollNo == s2.rollNo)
            return 0;
        else if (s1.rollNo > s2.rollNo)
            return 1;
        else
            return -1;
    }
}

class NameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.name.compareTo(s2.name);
    }
}

class MarkComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        if (s1.marks == s2.marks)
            return 0;
        else if (s1.marks > s2.marks)
            return 1;
        else
            return -1;
    }
}

class DOBComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.dob.compareTo(s2.dob);
    }
}

class StudentDriver {
    List<Student> studentList = new ArrayList<>();

    void init() throws ParseException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add Student\n2.Sorting by Rollno\n3.Sorting by Name\n4.Sorting by Marks\n5.Sorting by DOB\n6.Show Students\n7.Exit\nEnter the choice");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addStudent(sc);
                    showStudent(studentList);
                    break;
                case "2":
                    if (studentList.size() == 0) {
                        showAlert("Student list is empty");
                        return;
                    }
                    Collections.sort(studentList, new RollNoComparator());
                    showStudent(studentList);
                    break;
                case "3":
                    if (studentList.size() == 0) {
                        showAlert("Student list is empty");
                        return;
                    }
                    Collections.sort(studentList, new NameComparator());
                    showStudent(studentList);
                    break;
                case "4":
                    if (studentList.size() == 0) {
                        showAlert("Student list is empty");
                        return;
                    }
                    Collections.sort(studentList, new MarkComparator());
                    showStudent(studentList);
                    break;
                case "5":
                    if (studentList.size() == 0) {
                        showAlert("Student list is empty");
                        return;
                    }
                    Collections.sort(studentList, new DOBComparator());
                    showStudent(studentList);
                    break;
                case "6":
                    showStudent(studentList);
                    break;
                case "7":
                    showAlert("Thank You");
                    break;
                default:
                    showAlert("Invalid choice ,Enter valid choice");
                    init();
                    return;
            }
            if (choice.equals("7"))
                break;
        }
    }

    private void addStudent(Scanner sc) throws ParseException {
        System.out.println("Enter no of students to be added");
        String s = sc.nextLine();
        int n = Integer.parseInt(s);
        SimpleDateFormat dob = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Student name");
            String name = sc.nextLine();
            System.out.println("Enter date of Birth");
            String date = sc.nextLine();
            System.out.println("Enter Student roll no");
            int rollNo = sc.nextInt();
            System.out.println("Enter student mark");
            double marks = sc.nextDouble();
            sc.nextLine();
            studentList.add(new Student(rollNo, name, marks, dob.parse(date)));
            System.out.println("\t\t\tStudent " + name + " added succesfully");
        }
    }

    private void showStudent(List<Student> studentList) {
        if (studentList.size() == 0) {
            showAlert("Student list is empty");
            return;
        }
        System.out.println("\t\t\tStudent List");
        System.out.printf("%-15s %-20s %-15s %20s", "Roll No", "Name", "Mark", "DOB");
        System.out.println();
        for (Student student : studentList) {
            System.out.printf("%-15s %-20s %-15s %-120s", student.getRollNo(), student.getName(), student.getMarks(), student.getDob());
            System.out.println();
        }
    }

    private void showAlert(String alert) {
        System.out.println("\t\t\t" + alert);
    }
}

class StudentMain {
    public static void main(String[] args) throws ParseException {
        new StudentDriver().init();
    }
}

