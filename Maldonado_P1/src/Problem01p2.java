/* Maldonado, Ricardo
 * Problem 1 of Program Assignment 2
 * A program that encrypts and decrypts a 4-digit number.
 * This section focuses on decryption.
 */

import java.util.Scanner;

public class Problem01p2 {
	public static void main(String[] args) {
		//repeat from other class
		Scanner scnr2 = new Scanner(System.in); //resource leak?
		int userInitDigits;
		int firstDigit, secondDigit, thirdDigit, fourthDigit;
		int tempNum;
	
		//user input
		System.out.println("Enter an encrypted 4-digit number: ");
		userInitDigits = scnr2.nextInt();
	
		//separating digits - refactor?
		firstDigit = userInitDigits / 1000;
		firstDigit = firstDigit % 10;
		
		secondDigit = userInitDigits / 100;
		secondDigit = secondDigit % 10;
		
		thirdDigit = userInitDigits / 10;
		thirdDigit = thirdDigit % 10;
		
		fourthDigit = userInitDigits % 10;
		
		//putting the integers back in order from the other class
		tempNum = firstDigit;
		firstDigit = thirdDigit;
		thirdDigit = tempNum;
		
		tempNum = secondDigit;
		secondDigit = fourthDigit;
		fourthDigit = tempNum;
		
		//check whether or not to add 10 to numbers 0 to 6
		if(firstDigit <= 6 && firstDigit >= 0)
			firstDigit = firstDigit + 10;
		
		if(secondDigit <= 6 && secondDigit >= 0)
			secondDigit = secondDigit + 10;
		
		if(thirdDigit <= 6 && thirdDigit >= 0)
			thirdDigit = thirdDigit + 10;
		
		if(fourthDigit <= 6 && fourthDigit >= 0)
			fourthDigit = fourthDigit + 10;
		
		//subtract 7 from the digits to get original number
		firstDigit = firstDigit - 7;
		secondDigit = secondDigit -7;
		thirdDigit = thirdDigit -7;	
		fourthDigit = fourthDigit -7;
		
		//print to user
		System.out.printf("Decrypted: %d%d%d%d", firstDigit, secondDigit, thirdDigit, fourthDigit);
	}
	
}
