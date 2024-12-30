
public class Menu {

    public static void mainMenu() {

        Player p1 = new Player();
        Player p2 = new Player();
        AI computer = new AI();

        boolean twoPlayers = false;
        boolean end = false;

        // Checks if there are one or two players
        System.out.println("Welcome!" + "\n");
        System.out.println("Are you one, or two players?" + "\n");
        switch (InputValidator.numberSelection()) {
            case 1:
                System.out.println("Please enter your name: " + "\n");
                p1.name = InputValidator.nameCheck();
                System.out.println("Hi, " + p1.name + "!" + "\n");
                break;
            case 2:
                System.out.println("Please enter your names:" + "\n");
                p1.name= InputValidator.nameCheck();
                p2.name = InputValidator.nameCheck();
                twoPlayers = true;
                System.out.println("Hi, " + p1.name + ", and " + p2.name + "!" + "\n");
                break;
            default:
                System.out.println("Please select 1 or 2." + "\n");
        }

        // Menu
        do {
            System.out.println("==========|| MAIN MENU ||=========");
            System.out.println("Please select one of the following:" + "\n");
            System.out.println("1) Start Game" + "\n");
            System.out.println("2) Exit Game" + "\n");
                switch (InputValidator.numberSelection()) {
                    case 1:
                        if (twoPlayers) {
                            new Gameplay(p1, p2).vsHuman();

                        } else {
                            new Gameplay(p1, computer).vsComputer();
                        }
                        break;
                    case 2:
                        end = true;
                        break;
                    default:
                        System.out.println("Please select 1 or 2." + "\n");
                }
        } while (!end);
    }
}
