package interfaceandpackages.university.faculty;

public class Faculty {
    private String facultyname;
    private String facultyEmailId;
    private long facultyPhNo;
    private String facultyId;

    public Faculty(String facultyname, String facultyEmailId, long facultyPhNo, String facultyId) {
        this.facultyname = facultyname;
        this.facultyEmailId = facultyEmailId;
        this.facultyPhNo = facultyPhNo;
        this.facultyId = facultyId;
    }

    @Override
    public String toString() {
        return "Faculty-->" +
                "facultyname='" + facultyname + '\'' +
                ", facultyEmailId='" + facultyEmailId + '\'' +
                ", facultyPhNo=" + facultyPhNo +
                ", facultyId='" + facultyId + '\''
                ;
    }
}
