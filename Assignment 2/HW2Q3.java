/*	Assignment: HW2 Q1
 * 	Purpose: 	Use Assertion to determine if number is in range
 * 
 * 	Code written by: Logan White
 * 
 */


import java.util.Scanner;

public class HW2Q3{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		
		System.out.println("Please enter a number between 0 and 10:");		
		num = scanner.nextInt();
		
		//REQ print error "The Entered Number is out of Range
		assert num >= 0 && num <= 10 : "The entered number is out of range";
		
		System.out.println("Chosen Number: " + num);

        scanner.close();
		
	}
}