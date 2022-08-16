package main.com.adventure.world.scenes.s2_m2;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.doors.Door;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class HallwayDoorScene implements Scene {

    private Door door = new Door();

    /**
     * Creates the hallway door scene and sets the door's open state to false.
     */
    public HallwayDoorScene() {
        door.setIsOpen(false);
    }

    @Override
    public String getDescription() {
        if (!door.isOpen()) {
            return "One end of the hall. There's a large door with a large metal bar across it. You can't budge it.";
        } else {
            return "One end of the hall. There's a large door, but the bar has slid into the wall next to it.";
        }
    }

    /**
     * Builds the user-facing string of the possible directions for a given scene.
     * @return - the user-facing string of possible directions
     */
    public List<String> getPossibleDirections() {
        if (!door.isOpen()) {
            return new ArrayList(List.of(Direction.WEST));
        } else {
            return new ArrayList(List.of(Direction.WEST, Direction.EAST));
        }
    }

    @Override
    public Tangible getItem(String itemName) {
        if (itemName.equalsIgnoreCase(door.getName())) {
            return door;
        }
        return null;
    }

    @Override
    public void removeItem(Tangible item) {

    }

    @Override
    public void dig() {

    }
}
