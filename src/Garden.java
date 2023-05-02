import java.util.Scanner;

public class Garden {

    public void run(Scanner scanner) {

        String input = "";

        System.out.println("You see a path leading to a house. What do you do?");

        while(!input.equals("quit")) {

            input = scanner.nextLine();

            switch(input) {

                case "follow path":
                    System.out.println("You follow the path and arrive at the house. You knock on the door and it opens. You see a staircase leading up. What do you do?");
                    return;

                case "quit":
                    System.out.println("Thanks for playing!");
                    return;

                default:
                    System.out.println("I don't understand. Please try again.");
                    break;

            }

        }

    }

}
