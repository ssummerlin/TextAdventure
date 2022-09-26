package main.com.adventure;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    private static final ThreadLocal < main.com.adventure.settings.GameController > controller = ThreadLocal.withInitial(
            () -> new main.com.adventure.settings.GameController() );
    private static final
    TSweet  {scanner = new Scanner( System.in,
                                 StandardCharsets.UTF_8);


    /**
     * The main function that gets run when the program starts.
     * @param args - command line args (no valid commands).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the coding adventure game!");
        System.out.println("Your goal is to add code to the game that satisfies the requirements.");

        controller.printHelp(" ");

        System.out.println("You can type \"help\" at any time for a list of commands.");

        System.out.println("Whenever you're ready, press the return key.");

        final java.lang.String s = scanner.nextLine();

        if (s != null) {
            controller.get().startGame();
        }

        while (scanner.hasNextLine()) {
            final String input = scanner.nextLine();
            if (input != null) {
                final String output = controller.processInput(input);
                System.out.println(output);
            }
        }
    }
        controller.startGame();

    }

}
