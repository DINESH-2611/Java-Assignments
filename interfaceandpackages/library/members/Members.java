package interfaceandpackages.library.members;

public class Members {
    private String name;
    private String emailId;
    private long phNo;

    public Members(String name, String emailId, long phNo) {
        this.name = name;
        this.emailId = emailId;
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return "Members-->" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phNo=" + phNo
                ;
    }
}
