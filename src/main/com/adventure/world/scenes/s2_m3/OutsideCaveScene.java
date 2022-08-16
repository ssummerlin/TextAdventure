package main.com.adventure.world.scenes.s2_m3;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.doors.Door;
import main.com.adventure.world.objects.doors.DoorFactory;
import main.com.adventure.world.objects.keys.Key;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class OutsideCaveScene implements Scene {

    Door door = DoorFactory.buildDoor(false, 2);
    Key key = new Key();

    @Override
    public String getDescription() {
        String description = "You are at an entrance to a cave. There's a door protecting the cave. ";
        if (key != null) {
            description += "In the grass next to the road, you see a key.";
        }
        return description;
    }

    @Override
    public List<String> getPossibleDirections() {
        List<String> directions = new ArrayList<>(2);
        directions.add(Direction.WEST);
        if (door.isOpen()) {
            directions.add(0, Direction.EAST);
        }
        return directions;
    }

    @Override
    public Tangible getItem(String itemName) {
        if (itemName.equalsIgnoreCase("door")) {
            return door;
        } else if (itemName.equalsIgnoreCase("key")) {
            return key;
        }
        return null;
    }

    @Override
    public void removeItem(Tangible item) {
        if (item == key) {
            key = null;
        }
    }

    @Override
    public void dig() {

    }
}
