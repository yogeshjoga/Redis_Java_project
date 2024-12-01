import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args){
      int port = 8080; // You can use any available port
      try (ServerSocket serverSocket = new ServerSocket(port)) {
          System.out.println("Server started on port " + port);
          while (true) {
              try (Socket clientSocket = serverSocket.accept();
                   BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                   PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
              String input;
              while ((input = reader.readLine()) != null) {
                  System.out.println(input);
                  if (input.toLowerCase().contains("ping")) {
                      if (input.toLowerCase().startsWith("ping")) {
                          writer.print("+PONG\r\n"); writer.flush(); } } }
          } catch (IOException e) {
              System.err.println("Error handling client connection: " + e.getMessage());
          }
          }
      } catch (IOException e) { System.err.println("Could not start server: " + e.getMessage());
      }
  }
}
