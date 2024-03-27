package constructorsandinheritence;

public class Student {
    private String name;
    private String location;
    private long phNo;

    public Student(String name, String location, long phNo) {
        this.name = name;
        this.location = location;
        this.phNo = phNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getPhNo() {
        return phNo;
    }

    public void setPhNo(long phNo) {
        this.phNo = phNo;
    }

}
class ZSGSStudent extends Student{
    private String id;
    private String zsgsEmail;

    public ZSGSStudent(String name, String location, long phNo, String id, String zsgsEmail) {
        super(name, location, phNo);
        this.id = id;
        this.zsgsEmail = zsgsEmail;
    }

    @Override
    public String toString() {
        return "ZSGSStudent{" +
                "Name = "+getName()+
                ",Location = "+getLocation()+
                ",PhoneNo = "+getPhNo()+
                ",id='" + id + '\'' +
                ", zsgsEmail='" + zsgsEmail + '\'' +
                '}';
    }
}
class StudentDriver{
    public static void main(String[] args) {
        Student student=new ZSGSStudent("Ram","Nellai",9876543211l,"ZSGSR2024","ram.zsgs@gmail.com");
        System.out.println(student);
    }
}
