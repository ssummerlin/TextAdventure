package main.com.adventure.world.scenes.s2_m4;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Hole;
import main.com.adventure.world.objects.Shovel;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.doors.Door;
import main.com.adventure.world.objects.keys.Key;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class DigEscapeScene implements Scene {

    private Door door = new Door();
    private Key key = new Key();
    private Hole hole = new Hole(key);
    private Shovel shovel = new Shovel();

    @Override
    public String getDescription() {
        String description = "Another weird room with 4 walls and a DOOR. The ground is soft, though.";
        if (shovel != null) {
            description += " There's a SHOVEL leaning against the wall.";
        }
        if (!hole.isCovered() && key != null) {
            description += " A KEY is in the hole you dug up.";
        }
        return description;
    }

    @Override
    public List<String> getPossibleDirections() {
        if (door.isOpen()) {
            return new ArrayList(List.of(Direction.EAST));
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Tangible getItem(String itemName) {
        if (shovel != null && itemName.equalsIgnoreCase(shovel.getName())) {
            return shovel;
        }
        if (!hole.isCovered() && key != null && itemName.equalsIgnoreCase(key.getName())) {
            return key;
        }

        if (itemName.equalsIgnoreCase(door.getName())) {
            return door;
        }
        return null;
    }

    @Override
    public void removeItem(Tangible item) {
        if (item == shovel) {
            shovel = null;
        }
        if (item == key) {
            key = null;
        }
    }

    @Override
    public void dig() {
        hole.dig();
    }
}
