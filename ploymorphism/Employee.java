package ploymorphism;
public class Employee {
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
}
class HourlyEmployee extends Employee{
    private double hourSalary;

    public HourlyEmployee(int id, String name, long phoneNo, double hourSalary) {
        super(id, name, phoneNo);
        this.hourSalary = hourSalary;
    }

    public double getHourSalary() {
        return hourSalary;

    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }
    public void getEmployeeDetails(){
        System.out.println("EmpId = "+getId()+",Name = "+getName()+",PhoneNo = "+getPhoneNo()+",Hours salary = "+getHourSalary()+",Company name = "+getCompanyName());
    }
}
class SalariedEmployee extends  Employee{
    private double totalSalary;
    private double bonus;

    public SalariedEmployee(int id, String name, long phoneNo, double totalSalary, double bonus) {
        super(id, name, phoneNo);
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void getEmployeeDetails(){
        System.out.println("EmpId = "+getId()+",Name = "+getName()+",PhoneNo = "+getPhoneNo()+",Total salary = "+getTotalSalary()+"Bonus = "+getBonus()+",Company name = "+getCompanyName());
    }
}
class EmployeeDriver{
    public static void main(String[] args) {
        Employee employee=new Employee(222,"Ram",987654321);
        employee.getEmployeeDetails();
        Employee employee1=new HourlyEmployee(777,"Jack",1234567890,750);
        employee1.getEmployeeDetails();
        Employee employee2=new SalariedEmployee(888,"Tom",77777777,10000,2000);
        employee2.getEmployeeDetails();
    }
}
