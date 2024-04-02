package abstractclassandmethods;

import java.util.Scanner;

abstract public class Employee {
    private static String companyName="ZOHO";
    private int id;
    private String name;
    private long phoneNo;

    public Employee(int id, String name, long phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getCompanyName() {
        return companyName;
    }

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

    public void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }
    public void getEmployeeDetails(){
        System.out.println("EmpId = "+getId()+",Name = "+getName()+",PhoneNo = "+getPhoneNo()+",Company name = "+getCompanyName());
    }
    public abstract double calculatePay();
}
class HourlyEmployee extends Employee {
    private double hourSalary;
    private int hours;

    public HourlyEmployee(int id, String name, long phoneNo, double hourSalary,int hours) {
        super(id, name, phoneNo);
        this.hourSalary = hourSalary;
        this.hours=hours;
    }
    public void getEmployeeDetails(){
        System.out.println("\t\t\tDetails of Hourly employees\nEmpId = "+getId()+",Name = "+getName()+",PhoneNo = "+getPhoneNo()+",Hours salary = "+calculatePay()+",Company name = "+getCompanyName());
    }

    @Override
    public double calculatePay() {
        return hours*hourSalary;
    }

}
class SalariedEmployee extends Employee {
    private double bonus;
    private double salary;

    public SalariedEmployee(int id, String name, long phoneNo, double salary, double bonus) {
        super(id, name, phoneNo);
        this.salary = salary;
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void getEmployeeDetails(){
        System.out.println("\t\t\tDetails of Salaried employee\nEmpId = "+getId()+",Name = "+getName()+",PhoneNo = "+getPhoneNo()+",Total salary = "+calculatePay()+",Company name = "+getCompanyName());
    }

    @Override
    public double calculatePay() {
        return salary+bonus;

    }
}
class EmployeeDriver{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter employee name");
        String name=scanner.nextLine();
        System.out.println("Enter employee id");
        int id=scanner.nextInt();
        System.out.println("Enter phno");
        long phNo=scanner.nextLong();
        System.out.println("Enter no of hours");
        int hours=scanner.nextInt();
        System.out.println("Enter salary per hour");
        double hourSalary=scanner.nextDouble();
        System.out.println("Enter the salary");
        double salary=scanner.nextDouble();
        System.out.println("Enter the bonus");
        double bonus=scanner.nextDouble();
        Employee employee1=new HourlyEmployee(id,name,phNo,hourSalary,hours);
        Employee employee2=new SalariedEmployee(id,name,phNo,salary,bonus);
        employee1.getEmployeeDetails();
        employee2.getEmployeeDetails();
    }
}
