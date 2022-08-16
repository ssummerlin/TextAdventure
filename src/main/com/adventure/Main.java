package main.com.adventure;

import main.com.adventure.settings.GameController;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    private static GameController controller = new GameController();
    private static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     * The main function that gets run when the program starts.
     * @param args - command line args (no valid commands).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the coding adventure game!");
        System.out.println("Your goal is to add code to the game that satisfies the requirements.");

        controller.printHelp();

        System.out.println("You can type \"help\" at any time for a list of commands.");

        System.out.println("Whenever you're ready, press the return key.");

        scanner.nextLine();

        controller.startGame();

    }

}
