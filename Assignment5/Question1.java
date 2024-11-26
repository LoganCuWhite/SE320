/*	Assignment: HW5 Q1
 * 	Purpose: 	Finds the number of days elapsed since birthday
 * 
 * 	Code written by: Logan White
 * 
 * 
 */
import java.time.LocalDate;
import java.util.Scanner;


public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate currentLocalDate = LocalDate.now();
        int currentYear = currentLocalDate.getYear();
        int currentMonth = currentLocalDate.getMonthValue();
        int currentDay = currentLocalDate.getDayOfMonth();
        int birthYear = 2002;
        int birthMonth = 06;
        int birthDay = 10;
        
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print("Birth Year: ");
                birthYear = scanner.nextInt();

                System.out.print("Birth Month [1-12]: ");
                birthMonth = scanner.nextInt();
                if (birthMonth < 1 || birthMonth > 12) {
                    throw new IllegalArgumentException("NO! Months only go from 1 -12.");
                }

                System.out.print("Birth Day [1-31]: ");
                birthDay = scanner.nextInt();
                if (birthDay < 1 || birthDay > 31) {
                    throw new IllegalArgumentException("NO! Thats not a proper day of the month.");
                }

                validInput = true;
            } 
            catch (Exception e) {
            	
                System.out.println("Invalid input: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
        
        
        System.out.println("Entered birthday as: " + birthMonth + "/" + birthDay + "/" + birthYear);

        try {
        	Day birthDate = new Day(birthYear, birthMonth, birthDay); 
	        Day currentDate = new Day(currentYear, currentMonth, currentDay);
	        
	        //gets the number of days since birthday
	        int daysElapsed = currentDate.daysFrom(birthDate);
	
	        //prints out days elapsed
	        System.out.println("Days Elapsed Since Birth: " + daysElapsed);
        
        }
        catch (Exception e) {
        	System.out.println("Something failed");
        }
        

    }
}
