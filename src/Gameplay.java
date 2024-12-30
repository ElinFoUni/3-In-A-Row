// This class handles the core loop of the game

public class Gameplay {

    Player p1 = new Player();
    Player p2 = new Player();
    AI computer = new AI();

    public void vsHuman(String p1Name, String p2Name) {
        p1.name = p1Name;
        p2.name = p2Name;
    }

    public void vsComputer(String p1Name) {
        p1.name = p1Name;

    }



    // TODO Game Flow
        // Human Move
        // AI Move
        // Check valid move (empty, OOR)
    // TODO Check Win/Lose
    // TODO Check Draw

}
