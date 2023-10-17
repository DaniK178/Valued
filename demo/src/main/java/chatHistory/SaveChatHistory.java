package chatHistory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveChatHistory {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Chat session started.");

            while (true) {
                // Time and date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                String timeStamp = dateFormat.format(new Date());

                System.out.print("Enter your message (or type 'bye' to quit): ");

                // Creates a new line after each input
                String userInput = scanner.nextLine();

                if ("bye".equalsIgnoreCase(userInput)) {
                    break; // Exit the loop if the user enters "exit"
                }

                String fileName = "chat_history.txt";

                FileWriter fileWriter = new FileWriter(fileName, true);

                // Timestamp and user message in the same line
                fileWriter.write(timeStamp + " - employee: " + userInput + "\n");

                fileWriter.close();
            }

            System.out.println("Chat history saved to chat_history.txt.");
            // Handles errors outside scope
        } catch (IOException e) {
            System.err.println("An error occurred while saving the chat history.");
            e.printStackTrace();
        }
    }
}


