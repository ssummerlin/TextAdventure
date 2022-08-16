package main.com.adventure.world.scenes.s3_m2;

import main.com.adventure.world.Direction;
import main.com.adventure.world.Monster;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.Weapon;
import main.com.adventure.world.scenes.Scene;
import main.com.adventure.world.scenes.SceneDescriptionFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonsterSwordScene implements Scene {

    private Monster monster = new Monster("Oger", 5, 10);
    private Weapon sword = new Weapon("sword", 10);

    @Override
    public String getDescription() {
        try {
            return new SceneDescriptionFileReader().printTextFromFile("S4M2SceneFirstFight");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Scene failed to load description";
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
