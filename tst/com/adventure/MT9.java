package com.adventure;

import main.com.adventure.settings.CommandVerb;
import main.com.adventure.world.objects.doors.OmniDoor;
import main.com.adventure.world.objects.keys.OmniKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MT9 {

    @Test
    public void testOmniDoorKey() {
        OmniDoor door = new OmniDoor();
        OmniKey key = new OmniKey();

        assertEquals(0, door.getFirstWrongPin(key));
        door.unlock(key);
        assertFalse(door.isOpen);

        key.useItem(door);
        assertEquals(-1, door.getFirstWrongPin(key));
        door.unlock(key);
        assertTrue(door.isOpen);
    }

}
