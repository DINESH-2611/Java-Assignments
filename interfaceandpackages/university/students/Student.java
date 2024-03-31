package interfaceandpackages.university.students;

public class Student {
    private String studentName;
    private String studentEmailID;
    private long studentPhNo;
    private String studentId;

    public Student(String studentName, String studentEmailID, long studentPhNo, String studentId) {
        this.studentName = studentName;
        this.studentEmailID = studentEmailID;
        this.studentPhNo = studentPhNo;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student-->" +
                "studentName='" + studentName + '\'' +
                ", studentEmailID='" + studentEmailID + '\'' +
                ", studentPhNo=" + studentPhNo +
                ", studentId='" + studentId + '\''
                ;
    }
}
