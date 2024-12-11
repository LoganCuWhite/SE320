/*	Assignment: Final Assignment Q1
 * 	Purpose: 	Server
 * 
 * 	Code written by: Logan White
 * 
 */

import java.io.*;
import java.net.*;

public class Question1Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Question1 Server is up and running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client has Connected!");

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String weightInput = in.readLine();
                    String heightInput = in.readLine();

                    double weight = Double.parseDouble(weightInput);
                    double height = Double.parseDouble(heightInput);

                    double bmi = weight / (height * height);

                    String response = String.format("Calculated BMI: %.2f", bmi);
                    System.out.println(response);
                    out.println(response);
                    
                } 
                catch (NumberFormatException e) {
                    System.err.println("Invalid input from client: " + e.getMessage());
                    
                } 
                finally {
                    clientSocket.close();
                    
                }
            }
        } 
        catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
            
        }
    }
}
