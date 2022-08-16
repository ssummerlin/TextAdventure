package main.com.adventure.settings;

import main.com.adventure.CombatController;
import main.com.adventure.GameInputProcessor;
import main.com.adventure.player.Player;
import main.com.adventure.world.Monster;
import main.com.adventure.world.World;
import main.com.adventure.world.objects.Shovel;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.Weapon;
import main.com.adventure.world.objects.keys.Key;
import main.com.adventure.world.scenes.IMonsterScene;
import main.com.adventure.world.scenes.Scene;
import main.com.adventure.world.scenes.SceneDescriptionNotFoundException;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class GameController {

    private final Player player = new Player();
    private final World world = new World();
    private final GameInputProcessor inputProcessor = new GameInputProcessor();
    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    private boolean isInProgress = true;

    /**
     * Starts the game.
     */
    public void startGame() {
        if (AppSettings.story == AppSettings.Story.MT1_Beginning) {
            System.out.println("No crashes, so you win!");
            gameOver();
            return;
        }
        getName();
        System.out.println("Entering the world...");
        describeCurrentScene();

        if (AppSettings.story == AppSettings.Story.MT2_CaveEscape) {
            if (player.canOpenDoor()) {
                System.out.println("You have the power to open the door! You go through!");
            } else {
                System.out.println("Eh, you don't have the power to open a door. Not much of an adventurer...");
            }
            gameOver();
        } else {
            getNextCommand();
        }
    }

    private void move(String direction) {
        boolean isValid = getCurrentScene().getPossibleDirections().contains(direction.toUpperCase(Locale.ROOT));
        if (player.move(direction, isValid)) {
            describeCurrentScene();
        }
        if (player.getCurrentLocation() == world.scenes.size()) {
            showEndgameMessage();
            gameOver();
        }
    }

    private void examine(String itemName) {
        Tangible item = getCurrentScene().getItem(itemName);
        if (item != null && item.getDescription() != null) {
            System.out.println(item.getDescription());
        } else {
            System.out.println(itemName + " does not have a description.");
        }
    }

    private void use(String itemName) {
        if (itemName.contains(" on ")) {
            String[] itemNames = itemName.split(" on ");
            Tangible item = getTangibleObject(itemNames[0]);
            Tangible receiver = getCurrentScene().getItem(itemNames[1]);
            if (itemNames.length != 2) {
                printInvalidCommand();
            } else if (item == null) {
                System.out.println(itemNames[0] + " is not in your backpack.");
            } else if (receiver == null) {
                System.out.println(itemNames[1] + " is not here.");
            } else if (receiver.canUse(item)) {
                System.out.println("You use " + item.getName() + " on " + receiver.getName());
                receiver.useItem(item);
                player.removeItem(item);
                describeCurrentScene();
            } else {
                System.out.println("You can't use " + item.getName() + " on " + receiver.getName());
            }
        } else {
            //single item
            Tangible item = getCurrentScene().getItem(itemName);
            if (item != null) {
                item.use();
            }
        }
    }

    private Tangible getTangibleObject(String itemName) {
        if (AppSettings.canAccessFunctions(AppSettings.Story.MT8)) {
            return player.getItem(itemName);
        }
        if (itemName.equalsIgnoreCase("key")) {
            return player.getKey();
        } else if (itemName.equalsIgnoreCase("shovel")) {
            return player.getShovel();
        }
        return null;
    }

    private void getNextCommand() {
        if (!isInProgress) {
            return;
        }

        Command command = inputProcessor.getNextCommand();
        applyCommand(command);
        getNextCommand();
    }

    private void applyCommand(Command command) {
        if (command.getVerb().equalsIgnoreCase(CommandConstants.LOOK)) {
            describeCurrentScene();
        } else if (command.getVerb().equalsIgnoreCase(CommandConstants.MOVE)) {
            move(command.getObjectName());
        } else if (command.getVerb().equalsIgnoreCase(CommandConstants.HELP)) {
            printHelp();
        } else if (command.getVerb().equalsIgnoreCase(CommandConstants.USE)) {
            use(command.getObjectName());
        } else if (command.getVerb().equalsIgnoreCase(CommandConstants.DIG)) {
            dig();
        } else if (command.getVerb().equalsIgnoreCase(CommandConstants.EXAMINE)) {
            examine(command.getObjectName());
        } else if (command.getVerb().equalsIgnoreCase(CommandConstants.TAKE)) {
            take(command.getObjectName());
        } else {
            printInvalidCommand();
        }
    }

    private void startCombat() {
        if (!(getCurrentScene() instanceof IMonsterScene)) {
            return;
        }
        IMonsterScene scene = (IMonsterScene) getCurrentScene();
        Monster monster = scene.getMonster();
        CombatController controller = new CombatController(player, monster);
        controller.autosimulateCombat();
        if (controller.isPlayerDefeated()) {
            System.out.println("Ooof, you got beat. That's okay. Try again.");
            scene.lostFight();
        } else {
            System.out.println("You won!");
            scene.wonFight();
        }
        controller.reset();
        describeCurrentScene();
    }

    private void dig() {
        if (player.getShovel() != null) {
            getCurrentScene().dig();
            describeCurrentScene();
        } else {
            System.out.println("You don't have a shovel with which to dig.");
        }
    }

    private void take(String objectName) {
        Tangible item = getCurrentScene().getItem(objectName);
        if (item == null) {
            System.out.println("That item is no where to be found");
            return;
        }
        if (!item.canTake()) {
            System.out.println("You cannot take that!");
        }

        if (AppSettings.canAccessFunctions(AppSettings.Story.MT8)) {
            player.addItem(item);
        } else {
            setItem(item);
        }

        getCurrentScene().removeItem(item);
    }

    //Item Setters

    private void setItem(Tangible item) {
        if (item instanceof Key) {
            setKey((Key) item);
        } else if (item instanceof Shovel) {
            setShovel((Shovel) item);
        } else if (item instanceof Weapon) {
            setWeapon((Weapon) item);
        }

        System.out.println("You picked up the " + item.getName());
    }

    private void setWeapon(Weapon item) {
        player.setWeapon(item);
    }

    private void setShovel(Shovel item) {
        player.setShovel(item);
    }

    private void setKey(Key item) {
        player.setKey(item);
    }

    private void printInvalidCommand() {
        System.out.println("That command is invalid");
    }

    private void getName() {
        System.out.println("\n\nBefore we get started, what's your name?");
        String name = scanner.next();
        player.setName(name);
        if (player.getName().isEmpty()) {
            System.out.println("Looks like I didn't save the name. Something is wrong with either the setName or " +
                    "the getName function.");
            gameOver();
        } else {
            System.out.println("Welcome " + player.getName() + "!");
        }
    }

    private void describeCurrentScene() {
        if (player.getCurrentLocation() == world.scenes.size()) {
            isInProgress = false;
            return;
        }

        System.out.println();

        try {
            System.out.println(world.scenes.get(player.getCurrentLocation()).getDescription());
        } catch (SceneDescriptionNotFoundException e) {
            e.printStackTrace();
            isInProgress = false;
        }

        if (isInProgress) {
            System.out.println(world.getPossibleDirections(player.getCurrentLocation()));
        }
    }

    private void showEndgameMessage() {
        System.out.println("You've entered the cave and found a pot of gold!\n\nThanks for playing!");
    }

    private void gameOver() {
        System.out.println("Game Over");
        isInProgress = false;
    }

    /**
     * Prints the help script to the user.
     */
    public void printHelp() {
        if (AppSettings.story == AppSettings.Story.MT1_Beginning) {
            return;
        }
        System.out.println("Here are the list of commands that you can type:");
        System.out.println("- help (prints this message)");
        System.out.println("- move <direction>");
        if (AppSettings.story == AppSettings.Story.MT3_TestDirections) {
            System.out.println("- use <item>");
        } else if (AppSettings.story == AppSettings.Story.MT4_HouseAndCave) {
            System.out.println("- look <item>");
            System.out.println("- take <item>");
            System.out.println("- use <item>");
            System.out.println("- use <item> on <item>");
            System.out.println("- check items");
        } else if (AppSettings.story == AppSettings.Story.MT5_DigEscape) {
            System.out.println("- look <item>");
            System.out.println("- take <item>");
            System.out.println("- use <item>");
            System.out.println("- use <item> on <item>");
            System.out.println("- check items");
            System.out.println("- dig");
        }
    }

    private Scene getCurrentScene() {
        return world.scenes.get(player.getCurrentLocation());
    }

}
