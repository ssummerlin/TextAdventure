package main.com.adventure.world.scenes.s2_m3;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.keys.Key;
import main.com.adventure.world.objects.keys.KeyFactory;
import main.com.adventure.world.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

public class HouseScene implements Scene {

    Key key = KeyFactory.buildKey(2, "key");

    @Override
    public String getDescription() {
        String description = "You enter a house. It's smelly, old, and empty except for a desk on the far wall.";
        if (key != null) {
            description += " There's a key sitting on the desk.";
        }
        return description;
    }

    @Override
    public List<String> getPossibleDirections() {
        var list = new ArrayList(List.of(Direction.EAST));
        return list;
    }

    @Override
    public Tangible getItem(String itemName) {
        if (itemName.equalsIgnoreCase("key")) {
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
