package combinedassignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BmiCalculator {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        BmiCalculator bmiCalculator=new BmiCalculator();
        System.out.println("Enter the no of persons");
        int n=sc.nextInt();
        sc.nextLine();
        List<Person> persons=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
//            sc.nextLine();
            System.out.println("Enter person "+(i+1)+" name");
            String name=sc.nextLine();
            System.out.println("Enter person weight");
            double weight=sc.nextDouble();
            System.out.println("Enter person height in cm");
            double height=sc.nextDouble();
            sc.nextLine();
            double bmi= bmiCalculator.calculateBmi(weight,height);
            String temp=String.format("%.1f",bmi);
            bmi=Double.parseDouble(temp);
            String remark= bmiCalculator.checkRemark(bmi);
            Person person=new Person(name,weight,height,bmi,remark);
            persons.add(person);

        }
        Collections.sort(persons);
        System.out.println("Name          Bmi        Remark");
        for(Person person:persons){
            System.out.println(person);
        }

    }
    private double calculateBmi(double weight,double height){
        return weight/((height/100)*(height/100));
    }
    private String checkRemark(double bmi){
        if(bmi<18.5)
            return "Under weight";
        else if(bmi>=18.5 && bmi<25)
            return "Normal";
        else if(bmi>=25 && bmi<30)
            return "Over weight";
        else
            return "Obese";
    }
}
