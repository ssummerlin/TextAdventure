package main.com.adventure.world.scenes.s2_m3;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.doors.Door;
import main.com.adventure.world.objects.doors.DoorFactory;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class HouseOutsideScene implements Scene {

    Door door = DoorFactory.buildDoor(false, 1);

    @Override
    public String getDescription() {
        String description = "You come up to a house. It has no windows on the bottom floor, but there is a door.";
        return description;
    }

    @Override
    public List<String> getPossibleDirections() {
        List<String> directions = new ArrayList<>(2);
        directions.add(Direction.EAST);
        if (door.isOpen()) {
            directions.add(0, Direction.WEST);
        }
        return directions;
    }

    @Override
    public Tangible getItem(String itemName) {
        if (itemName.equalsIgnoreCase("door")) {
            return door;
        }
        return null;
    }

    @Override
    public void removeItem(Tangible item) { /*intentionally left blank*/ }

    @Override
    public void dig() {

    }
}
