package main.com.adventure.world.scenes.s2_m2;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.TangibleListener;
import main.com.adventure.world.objects.keys.ConsoleKey;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class ConsoleScene implements Scene {

    ConsoleKey key;

    /**
     * Creates the console scene with the required listener.
     * @param listener - the listener for when the console is used.
     */
    public ConsoleScene(TangibleListener listener) {
        key = new ConsoleKey(listener);
    }

    @Override
    public String getDescription() {
        return "A rather boring room with empty picture frames on the wall. There is a CONSOLE that has a big lever " +
                "that you could pull down. Do you dare?";
    }

    @Override
    public List<String> getPossibleDirections() {
        return new ArrayList<>(List.of(Direction.EAST));
    }

    @Override
    public Tangible getItem(String itemName) {
        if (itemName.equals(key.getName())) {
            return key;
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
