import java.util.Scanner;

public class InputValidator {
    Scanner sc = new Scanner(System.in);
    // Check player input
     static void nameCheck(String input) {
         if (input == null || input.equals("") || input.equals(" ")) {
             System.out.println("Please enter a valid name." + System.lineSeparator());
         }
    }





}
