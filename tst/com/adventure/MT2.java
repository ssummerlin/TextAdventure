package com.adventure;

import main.com.adventure.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MT2 {

    private Player player;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        player = new Player();
        System.setOut(new PrintStream(outContent));
        checkPlayerLevel();
    }

    private void checkPlayerLevel() {
        assertEquals(player.level, 5, "The player's level should always be 5");
    }

    @Test
    void canOpenDoor() {
        checkPlayerLevel();
        assertEquals(true, player.canOpenDoor(), "The player should be able to open the door at level " + player.level);
        checkPlayerLevel();

        player.level = 4;
        assertEquals(false, player.canOpenDoor(), "The player should not be able to open the door at level " + player.level);

        player.level = 0;
        assertEquals(false, player.canOpenDoor(), "The player should not be able to open the door at level " + player.level);

        player.level = 10;
        assertEquals(true, player.canOpenDoor(), "The player should be able to open the door at level " + player.level);
    }

    @Test
    void setName() {
        assertTrue(player.getName() == null || player.getName().isBlank(), "The player's name should start as a blank or null string.");
        String testName = "Test name";
        player.setName(testName);
        assertEquals(testName, player.getName());
        assertEquals(String.format("Your name is now %s", testName), outContent.toString().trim());
    }
}