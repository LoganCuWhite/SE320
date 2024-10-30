/*	Assignment: HW4 Q3
 * 	Purpose: 	Internationalization for the given number 
 * 				Parses a string into a number
 * 	
 * 	Code written by: Logan White
 * 
 * 
 */
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Question3 {
    public static void main(String[] args) {
    	NumberFormat ukFormat = NumberFormat.getInstance(Locale.UK);
    	NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    	NumberFormat numberParse = NumberFormat.getNumberInstance();
    	
    	double number = 12345.678;
        String NotaNumber = "12,345.678";

        System.out.println("Given Number: " + number);
        
        //A converting the number to Uk Number format
        ukFormat.setMinimumFractionDigits(2);
        ukFormat.setMaximumFractionDigits(2);
        String UkNumFormat = ukFormat.format(number);
       
        //B converting the number to US Currency format
        String UsCurrFormat =  usCurrencyFormat.format(number);
        
        System.out.println("UK format: " + UkNumFormat);
        System.out.println("US currency format: " +UsCurrFormat);
        
        //C turning the string into a number
        try {
            Number parsedNumber = numberParse.parse(NotaNumber);
            
            System.out.println("String to Number: " + parsedNumber);
            
        } 
        catch (ParseException e) {
            System.out.println("Error parsing the number.");
        }
        
    }
}
