public class Menu {

    public static void mainMenu() {

        // Saving the names as strings so that I can pass them to the gameplay class
        String p1Name = "Unknown";
        String p2Name = "Unknown";

        boolean twoPlayers = false;
        boolean end = false;

        // Checks if there are one or two players
        System.out.println("Welcome!" + "\n");
        System.out.println("Are you one, or two players?" + "\n");
        switch (InputValidator.menuSelection()) {
            case 1:
                System.out.println("Please enter your name: " + "\n");
                p1Name = InputValidator.nameCheck();
                System.out.println("Hi, " + p1Name + "!" + "\n");
                break;
            case 2:
                System.out.println("Please enter your names:" + "\n");
                p1Name= InputValidator.nameCheck();
                p2Name = InputValidator.nameCheck();
                twoPlayers = true;
                System.out.println("Hi, " + p1Name + ", and" + p2Name + "!" + "\n");
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
                switch (InputValidator.menuSelection()) {
                    case 1:
                        if (twoPlayers) {
                            new Gameplay().vsHuman(p1Name, p2Name);

                        } else {
                            new Gameplay().vsComputer(p1Name);
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
