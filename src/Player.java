// Used to create players and asks how many people are playing

import java.util.Scanner;

public class Player {
    String name;
    Scanner sc = new Scanner(System.in);

    public Player() {
        this.name = "Unknown";
    }

    public void playerName(String name) {
        this.name = InputValidator.nameCheck(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Player{" +
                "Hi, '" + name + "!" + '\'' +
                '}';
    }

}
