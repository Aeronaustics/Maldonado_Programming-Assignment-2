/* Maldonado, Ricardo
 * Problem 1 of Program Assignment 2
 * A program that encrypts and decrypts a 4-digit number.
 * This section focuses on encryption.
 */

import java.util.Scanner;

public class Problem01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in); //resource leak?
		int userInitDigits;
		//Could probably do an array for below instead but more comfortable with separate variables at the moment.
		int firstDigit, secondDigit, thirdDigit, fourthDigit;
		int tempNum;

		//Get users Input: 4-Digit Number
		System.out.println("Enter a 4-digit number: ");
		userInitDigits = scnr.nextInt(); //Should I use a long? doesn't seem that necessary. 
		
		//storing each individual integer in a variable. According to a forum I can use a while loop? 
		//Not sure at the moment, basing mine on the ZyBooks phone number example.
		
		firstDigit = userInitDigits / 1000;
		firstDigit = firstDigit % 10;
		
		secondDigit = userInitDigits / 100;
		secondDigit = secondDigit % 10;

		thirdDigit = userInitDigits / 10;
		thirdDigit = thirdDigit % 10;
		
		fourthDigit = userInitDigits % 10;
		
		//Add 7 to each digit and divide by 10 to get the remainder - should I use modulus to get remainder then?
		
		firstDigit = (firstDigit + 7) % 10;
		
		secondDigit = (secondDigit + 7) % 10;
		
		thirdDigit = (thirdDigit + 7) % 10;	
		
		fourthDigit = (fourthDigit + 7) % 10;
	
		//Swap the places of each 3412
		tempNum = firstDigit;
		firstDigit = thirdDigit;
		thirdDigit = tempNum;
		
		tempNum = secondDigit;
		secondDigit = fourthDigit;
		fourthDigit = tempNum;
		
		//Print result to user
		System.out.printf("Ecrypted: %d%d%d%d", firstDigit, secondDigit, thirdDigit, fourthDigit);	
	}
}
