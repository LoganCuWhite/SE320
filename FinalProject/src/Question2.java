/*	Assignment: Final Assignment Q2
 * 	Purpose: 	Multi-threaded Server
 * 
 * 	Code written by: Logan White
 * 
 */


import java.io.*;
import java.net.*;

public class Question2 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Question2 Multi-threaded BMI Server is up and running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected!");

                new Thread(new ClientHandler(clientSocket)).start();
                
            }
            
        } 
        catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String weightInput = in.readLine();
            String heightInput = in.readLine();

            double weight = Double.parseDouble(weightInput);
            double height = Double.parseDouble(heightInput);

            double bmi = weight / (height * height);

            String response = String.format("Calculated BMI: %.2f", bmi);
            out.println(response);

        } 
        catch (NumberFormatException e) {
            System.err.println("Invalid input from client: " + e.getMessage());
        
        } 
        catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        
        }
        finally {
            try {
                clientSocket.close();
                System.out.println("Client connection closed.");
            
            }
            catch (IOException e) {
                System.err.println("Failed to close client socket: " + e.getMessage());
            
            }
        }
    }
}
