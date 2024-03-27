package assignementclassandobjects;

public class Emplyoee {
    private static String companyName;
    private int id;
    private String name;
    private long phoneNo;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Emplyoee.companyName = companyName;
    }
}
