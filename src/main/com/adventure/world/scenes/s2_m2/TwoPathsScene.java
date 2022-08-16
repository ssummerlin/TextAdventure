package main.com.adventure.world.scenes.s2_m2;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class TwoPathsScene implements Scene {

    @Override
    public String getDescription() {
        return "You're in the middle of a hallway. Nothing really important here. Where will you go?";
    }

    @Override
    public List<String> getPossibleDirections() {
        return new ArrayList(List.of(Direction.WEST, Direction.EAST));
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
