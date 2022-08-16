package com.adventure;

import main.com.adventure.world.Direction;
import main.com.adventure.world.objects.Hole;
import main.com.adventure.world.objects.doors.Door;
import main.com.adventure.world.objects.keys.Key;
import main.com.adventure.world.scenes.s2_m4.DigEscapeScene;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MT5 {

    @Test
    public void testHole() {
        Key key = new Key();
        Hole hole = new Hole(key);

        assertTrue(hole.isCovered());
        hole.dig();
        assertFalse(hole.isCovered());
    }

    @Test
    public void testScene() {
        DigEscapeScene scene = new DigEscapeScene();
        
        assertNotNull(scene.getItem("shovel"));
        assertNull(scene.getItem("key")); //null until the hole is dug
        assertNotNull(scene.getItem("door"));

        scene.dig();
        assertNotNull(scene.getItem("key"));
        Key key = (Key) scene.getItem("key");
        scene.removeItem(key);
        assertNull(scene.getItem("key")); //null until the hole is dug

        Door door = (Door) scene.getItem("door");
        door.useItem(key);
        assertTrue(door.isOpen());

        assertEquals(new ArrayList(List.of(Direction.EAST)), scene.getPossibleDirections());
    }
}
