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
    public void getEmployeeDetails(Employee employee){
        System.out.println("EmpId = "+employee.getId()+",Name = "+employee.getName()+",PhoneNo = "+employee.getPhoneNo()+",Company name = "+employee.getCompanyName());
    }
    public void getEmployeDetails(HourlyEmployee hourlyEmployee){
        System.out.println("EmpId = "+hourlyEmployee.getId()+",Name = "+hourlyEmployee.getName()+",PhoneNo = "+hourlyEmployee.getPhoneNo()+",Hour salary = "+hourlyEmployee.getHourSalary()+",Company name = "+hourlyEmployee.getCompanyName());
    }
    public void getEmployeDetails(SalariedEmployee salariedEmployee){
        System.out.println("EmpId = "+salariedEmployee.getId()+",Name = "+salariedEmployee.getName()+",PhoneNo = "+salariedEmployee.getPhoneNo()+",Hour salary = "+salariedEmployee.getTotalSalary()+",Bonus = "+salariedEmployee.getBonus()+",Company name = "+salariedEmployee.getCompanyName());
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
}
class EmployeeDriver{
    public static void main(String[] args) {
        Employee employee=new Employee(222,"Ram",987654321);
        employee.getEmployeeDetails(employee);
        Employee employee1=new HourlyEmployee(777,"Jack",1234567890,750);
        HourlyEmployee hourlyEmployee=(HourlyEmployee)employee1;
        employee.getEmployeDetails(hourlyEmployee);
        Employee employee2=new SalariedEmployee(888,"Tom",77777777,10000,2000);
        SalariedEmployee salariedEmployee=(SalariedEmployee)employee2;
        employee.getEmployeDetails(salariedEmployee);
    }
}
