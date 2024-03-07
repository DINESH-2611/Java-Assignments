package combinedassignment1;

import java.util.Scanner;

public class AverageWeight {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        double sum=0;
        for(int i=1;i<11;i++){
            System.out.println("Enter the weight of person "+i);
            sum+=sc.nextDouble();
        }
        double avg=sum/10;
        System.out.println("The average weight of 10 peoples is "+avg);
    }
}
