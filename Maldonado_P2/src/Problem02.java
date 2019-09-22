/* Maldonado, Ricardo
 * Problem 2 of Program Assignment 2
 * A program that calculates a person's BMI
 */

import java.util.Scanner;

public class Problem02 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int unitType;
		double userWeight;
		double userHeight;
		double usersBMI = 0;
		
		System.out.println("Welcome to the BMI Calculator");
		System.out.println("Press 1 for Imperial or 2 for Metric: ");
		unitType = scnr.nextInt();
	
		if (unitType == 1)
		{
			System.out.println("What is your weight in pounds?: ");
			userWeight = scnr.nextDouble();
		
			System.out.println("What is your height in inches?: ");
			userHeight = scnr.nextDouble();
			
			usersBMI = (703 * userWeight) / Math.pow(userHeight, 2);
			System.out.print("Your current BMI: ");
			System.out.printf("%.1f\n", usersBMI);
		}
		
		else if (unitType == 2)
		{
			System.out.println("What is your weight in kilograms?: ");
			userWeight = scnr.nextDouble();
		
			System.out.println("What is your height in meters?: ");
			userHeight = scnr.nextDouble();
			
			usersBMI = userWeight / Math.pow(userHeight, 2);
			System.out.print("Your current BMI: ");
			System.out.printf("%.1f\n", usersBMI);
		}
		
		//Display Data to User
		System.out.println("BMI Categories:");
		System.out.println("Underweight = <18.5");
		System.out.println("Normal weight = 18.5-24.9");
		System.out.println("Overweight = 25-29.9");
		System.out.println("Obesity = BMI of 30 or greater");
	}
}
