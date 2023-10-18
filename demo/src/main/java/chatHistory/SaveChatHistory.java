package chatHistory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveChatHistory {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm");

            String timeStamp = dateFormat.format(new Date());
            String fileName = "chat_history_" + timeStamp + ".txt";

            while (true) {
                System.out.print("Enter your message (or type 'exit' to quit): ");
                String userInput = scanner.nextLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                FileWriter fileWriter = new FileWriter(fileName, true);

                fileWriter.write(timeStamp + " - employee: " + userInput + "\n");

                fileWriter.close();
            }

            System.out.println("Chat history saved to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the chat history.");
            e.printStackTrace();
        }
    }
}