package main.com.adventure.world.scenes.s3_m2;

import main.com.adventure.world.Direction;
import main.com.adventure.world.Monster;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.Weapon;
import main.com.adventure.world.scenes.IMonsterScene;
import main.com.adventure.world.scenes.SceneDescriptionFileReader;
import main.com.adventure.world.scenes.SceneDescriptionNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonsterScene implements IMonsterScene {

    private Monster monster = new Monster("Oger", 5, 10);
    private Weapon sword = new Weapon("sword", 10);
    private String descriptionFileName = "S4M2Scene.txt";

    public Monster getMonster() {
        return monster;
    }

    @Override
    public void removeMonster(Monster monsterToRemove) {
        if (monsterToRemove == this.monster) {
            this.monster = null;
        }
    }

    @Override
    public void lostFight() {
        descriptionFileName = "S4M2SceneFirstFight.txt";
    }

    @Override
    public void wonFight() {
        descriptionFileName = "S4M2SceneVictory.txt";
        monster = null;
    }

    /**
     * THe user-friendly description to be displayed.
     * @return - the monster's description as a string that can be displayed to the user.
     * @throws SceneDescriptionNotFoundException - if the scene's description could not be found.
     */
    public String getDescription() throws SceneDescriptionNotFoundException {
        try {
            return new SceneDescriptionFileReader().printTextFromFile(descriptionFileName);
        } catch (IOException e) {
            throw new SceneDescriptionNotFoundException();
        }
    }

    @Override
    public List<String> getPossibleDirections() {
        if (monster == null) {
            return new ArrayList(List.of(Direction.EAST));
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Tangible getItem(String itemName) {
        if (sword != null && itemName.equalsIgnoreCase(sword.getName())) {
            return sword;
        }
        return null;
    }

    @Override
    public void removeItem(Tangible item) {
        if (item == sword) {
            sword = null;
        }
    }

    @Override
    public void dig() {

    }
}
