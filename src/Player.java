public class Player {
    String name;
    int score;

    public Player() {
        name = "Unknown";
        score = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Hi, '" + name + "!" + '\'' +
                '}';
    }

}
