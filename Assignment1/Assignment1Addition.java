/* SE 320 Assignment -1
 * Completed by: Logan White
 * purpose: User Enters two integers, Sum is displayed
 * 
*/
//import java.util.Scanner;

import java.util.Locale;
import java.util.Scanner;

public class Assignment1Addition{


	public static void main(String[] args) {
		Assignment1Addition starter = new Assignment1Addition();		

		double[] n = starter.GetNumbers();
		double addition = n[0] + n[1];
		
		System.out.println(n[0] + " + " + n[1] + " = " + addition);
	}
	
	public double[] GetNumbers() {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		double[] n = {0,0};
		int i = 0;
		
		while (i <2) {
			try {
		        System.out.print("Enter Number: ");
		        n[i] = Double.parseDouble(scanner.next());
				i = i+1;
			}
			catch(Exception e) {
				System.out.println("That Wasnt A Number!");
				scanner.reset();
			}
		}
        scanner.close();
		return n;
		
	}

}