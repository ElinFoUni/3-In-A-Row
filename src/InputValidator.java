import java.util.Scanner;

public class InputValidator {
    static Scanner sc = new Scanner(System.in);

    // checks if the Player name is a valid string or not. A bit wonky with two players
     public static String nameCheck() {
         sc.nextLine();
         String name = sc.nextLine();
         // Java 11 or later, otherwise it needs to say: input.trim().isEmpty()
         while (name == null || name.isBlank()) {
             System.out.println("Please enter a valid name." + System.lineSeparator());
             name = sc.nextLine();
         }
         return name;
     }

    // Checks menu/move selections for errors
    public static Short numberSelection() {
         while (!sc.hasNextShort()) {
             System.out.println("Please enter a valid number." + System.lineSeparator());
             sc.nextLine();
         }
        return sc.nextShort();
    }
}
