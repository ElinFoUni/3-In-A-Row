public class Player {
    String name;
    int score;

    public Player() {
        this.name = "Unknown";
        this.score = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Hi, '" + name + "!" + '\'' +
                '}';
    }

}
