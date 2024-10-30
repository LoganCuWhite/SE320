import java.io.File;
/*	Assignment: HW4 Q2
 * 	Purpose: 	Reads Words from a text file and displays them in Ascending order
 * 				[Utilization of a Tree Set]
 * 				//As a note Tree Set deletes duplicates read in from text file 
 * 
 * 	Code written by: Logan White
 * 
 * 
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Question2 {
    public static void main(String[] args) {
    	//looks for the text file Provided
    	File file =new File(System.getProperty("user.dir")+"\\src\\Question2textFile.txt");
    	
        try{
        	Scanner  scanner = new Scanner(file);
        	TreeSet<String> words = readTextfile(scanner, file);
        	scanner.close();
        	
            System.out.println("Nonduplicate words in Ascending order: " + words);
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

    }
    
    
    public static TreeSet<String> readTextfile(Scanner scanner, File file){
    	//reads the text file 
    	TreeSet<String> words = new TreeSet<>();
    	while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
    	}
    	return words;
    }
    
}
    
