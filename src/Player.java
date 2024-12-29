// Used to create players and asks how many people are playing

import java.util.Scanner;

public class Player {
    String name;
    Scanner sc = new Scanner(System.in);

    public Player() {
        this.name = "Unknown";
    }

    @Override
    public String toString() {
        return "Player{" +
                "Hi, '" + name + "!" + '\'' +
                '}';
    }

}
