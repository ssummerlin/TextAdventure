package main.com.adventure.world.scenes.s2_m1;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.doors.Door;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class CaveEscapeScene implements Scene {

    Door door = new Door();

    @Override
    public String getDescription() {
        return "You find yourself in a dense wood. The trees are so thick you can't go through them. To the WEST of " +
                "you is a path that leads to a door. You feel weak, but you may have the strength to push it open.";
    }

    @Override
    public List<String> getPossibleDirections() {
        return new ArrayList(List.of(Direction.WEST));
    }

    @Override
    public Tangible getItem(String itemName) {
        return null;
    }

    @Override
    public void removeItem(Tangible item) {

    }

    @Override
    public void dig() {

    }
}
