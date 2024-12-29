import java.util.Scanner;

public class InputValidator {
    Scanner sc = new Scanner(System.in);

    // checks if the player name is valid or not.
     static String nameCheck(String input) {
         if (input == null || input.isBlank()) { // Java 11 or later, otherwise it needs to say: input.trim().isEmpty()
             System.out.println("Please enter a valid name." + System.lineSeparator());
         }
         return input;
     }

     // TODO Move check
    // TODO menu check?





}
