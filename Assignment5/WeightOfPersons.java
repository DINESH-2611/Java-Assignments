package Assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WeightOfPersons {
	static Scanner sc=new Scanner(System.in);
	static boolean repeat=true; 
	 static int noOfPersons;
	 static List<Integer>[] persons;
	public static void main(String[] args) {
		System.out.println("Enter the no of persons");
		noOfPersons=sc.nextInt();
		persons=new List[noOfPersons];
		for (int i = 0; i < persons.length; i++) {
			persons[i]=new ArrayList<Integer>();
		}
		do {
			System.out.println("Select the input");
			System.out.println("1.Adding weights for the nth person\n2.Get Minimum of nth person\n3.Exit");
			int input=sc.nextInt();
			switch (input) {
			case 1: {
				System.out.println("Enter the nth person whose weight need to add");
				int person=sc.nextInt();
				System.out.println("Enter no of weights to add");
				int count=sc.nextInt();
				
				if(person>noOfPersons)
					System.out.println("The Person "+person+" Greater than the Numbers of persons");
				else {
					
					for (int i = 0; i <count; i++) {
						System.out.println("Enter the weight");
						int weight=sc.nextInt();
						addWeight(person, weight);
					}
					System.out.println("Weight addded succesfully");
				}
				break;
			}
            case 2: {
            	System.out.println("Enter the nth person whose minimum weight needs to be displayed");
            	int person=sc.nextInt();
            	if(person>noOfPersons)
					System.out.println("The Person "+person+" Greater than the Numbers of persons");
            	else {
            		if(persons[person-1].isEmpty())
						System.out.println("Person "+person+" weight list doesn't have weight data to find the minimum.So Add the weight data first");
            		else {
            			int min=minWeight(person);
                		System.out.println("Minimum weight of Person "+person+" is "+min);
            		}
            	}
				
				break;
			}
            case 3: {
				repeat=false;
				break;
			}
			default:
				System.out.println("Enter valid input");
			}
		} while (repeat);
	}
	
	public static void addWeight(int person,int weight) {
		if(person>noOfPersons)
			System.out.println("The Person "+person+" Greater than the Numbers of persons");
		else {
			persons[person-1].add(weight);
		}
	}
	public static int minWeight(int person) {
		return Collections.min(persons[person-1]);
	}

}
