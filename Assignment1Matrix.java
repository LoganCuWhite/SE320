/* SE 320 Assignment -1
 * Completed by: Logan White
 * purpose: Generates Matrix User chooses Coordinates of number to display
 * 
*/
//import java.util.Scanner;
import java.lang.Math;
import java.util.Locale;
import java.util.Scanner;

public class Assignment1Matrix{


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Assignment1Matrix starter = new Assignment1Matrix();		
		int[][] gridMatrix = starter.createMatrix();
		int[] coordinates = starter.getCoordinates(scanner);
		
		boolean cordsValid = false;
		int xLength = gridMatrix[0].length;
		int yLength = gridMatrix.length;
		
		
		while(!cordsValid) {
			
			if(coordinates[0] <= xLength && coordinates[0] >= 0  ) {
				if(coordinates[1] <= yLength && coordinates[1] >= 0  ) {
					System.out.println("Location Value X:" + (coordinates[0]+1) +" Y:"+ (coordinates[1]+1) + ": " + gridMatrix[coordinates[0]][coordinates[1]] );
					cordsValid = true;
				}
				else if (coordinates[1] > yLength || coordinates[1] < 0  ) {
					//fail
					System.out.println("Re-choose Cooridnates Y was Invalid");
					coordinates = starter.getCoordinates(scanner);
				}
			}
			else if (coordinates[0] > xLength || coordinates[0] < 0  ) {
				if(coordinates[1] <= yLength && coordinates[1] >= 0  ) {
					System.out.println("Re-choose Cooridnates X was Invalid");
					coordinates = starter.getCoordinates(scanner);
				}
				else {
					//fail
					System.out.println("Re-choose Cooridnates both were Invalid");
					coordinates = starter.getCoordinates(scanner);
				}		
			}
		}
		
        scanner.close();
		
		
	}

	public int[][] createMatrix(){
		int[][] matrix  = new int [100] [100];

		for (int i = 0; i < 100; i++) {
			System.out.println(" ");
			for (int j = 0; j < 100; j++) {
				matrix[j][j] = (int)((Math.random()*1000)/10);
			}
			
		}
		
		return matrix;
	}
	
	public int[] getCoordinates(Scanner scanner) {
		scanner.useLocale(Locale.US);
		
		int [] coords= {0,0};
		String CordType;
		
		int i = 0;
		while (i <2) {
	
			try {
				if (i == 0) {
					CordType = "X";
				}
				else if (i == 1){
					CordType = "Y";
				}
				else {
					CordType = " ?";
				}
				
		        System.out.print("Enter " + CordType + " Coordinate [1-100]:");
		        coords[i] = Integer.parseInt(scanner.next()) -1;
		         
				i = i+1;
			}
			catch(Exception e) {
				System.out.println("That Wasnt A Number!");
				scanner.reset();
			}
		}
		scanner.reset();
        
		return coords;
	}

}