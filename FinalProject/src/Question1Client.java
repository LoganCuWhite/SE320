/*	Assignment: Final Assignment Q1
 * 	Purpose: 	Client
 * 
 * 	Code written by: Logan White
 * 
 * 
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Question1Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
             
        	Scanner scanner = new Scanner(System.in);

            System.out.println("Enter weight (kg):");
            double weight = scanner.nextDouble();
            System.out.println("Enter height (m):");
            double height = scanner.nextDouble();

            out.println(weight);
            out.println(height);
            
            
            String response = in.readLine();
            System.out.println(response);

            scanner.close();
            
        } 
        catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
