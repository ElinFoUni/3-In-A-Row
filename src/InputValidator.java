import java.util.Scanner;

public class InputValidator {
    static Scanner sc = new Scanner(System.in);

    // checks if the Player name is valid or not.
     public static String nameCheck() {
         String name = sc.nextLine();
         // Java 11 or later, otherwise it needs to say: input.trim().isEmpty()
         while (name == null || name.isBlank()) {
             System.out.println("Please enter a valid name." + System.lineSeparator());
             name = sc.nextLine();
         }
         return name;
     }

     //TODO Check if you need input.isEmpty() ^^

    // TODO Move check number

    // Checks menu selections for errors
    public static Short menuSelection() {
         while (!sc.hasNextShort()) {
             System.out.println("Please enter a valid number." + System.lineSeparator());
         }
        return sc.nextShort();
    }


    /*static boolean isShort(String number) {
        try {
            Short.parseShort(number);
            return true;
            }
        catch (NumberFormatException e){
            return false;
            }
    }*/




}
