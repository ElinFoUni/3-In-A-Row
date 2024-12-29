import java.sql.SQLOutput;
import java.util.Scanner;


public class Menu {


    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        Player humanPlayer = new Player();
        Player humanPlayer2 = new Player();

        System.out.println("Welcome!");
        System.out.println("Please enter your name: ");
        humanPlayer.name = InputValidator.nameCheck();
        humanPlayer2.name = InputValidator.nameCheck();

        while (!end) {
            boolean twoPlayers = false;
            System.out.println("Are you one or two players?");
            switch (InputValidator.menuSelection()) {
                case 1:

            }



        }
        end = true;
    }







}
