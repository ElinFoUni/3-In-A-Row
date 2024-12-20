// Used to create players and asks how many people are playing

public class Player {
    String name = "unknown";

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Hi, '" + name + "!" + '\'' +
                '}';
    }
}
