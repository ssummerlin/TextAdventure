package com.adventure;

import main.com.adventure.GameInputProcessor;
import main.com.adventure.player.Backpack;
import main.com.adventure.player.Player;
import main.com.adventure.settings.Command;
import main.com.adventure.settings.CommandVerb;
import main.com.adventure.world.objects.keys.Key;
import main.com.adventure.world.objects.keys.KeyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MT8 {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testBackpackAddRemoveItem() {
        Key key = KeyFactory.buildKey(1, "1");
        Key secondKey = KeyFactory.buildKey(2, "2");
        Backpack backpack = new Backpack();
        backpack.addItem(key);
        backpack.addItem(secondKey);
        assertNotNull(backpack.getItem(key.getName()));
        assertNotNull(backpack.getItem(secondKey.getName()));
        backpack.removeItem(key);
        backpack.removeItem(secondKey);
        assertNull(backpack.getItem(key.getName()));
        assertNull(backpack.getItem(secondKey.getName()));
    }

    @Test
    public void testBackpackLimit() {
        final String invalidKey = "Invalid";
        Backpack backpack = new Backpack();
        backpack.addItem(KeyFactory.buildKey(1, "1"));
        backpack.addItem(KeyFactory.buildKey(2, "2"));
        backpack.addItem(KeyFactory.buildKey(3, "3"));
        backpack.addItem(KeyFactory.buildKey(4, "4"));
        backpack.addItem(KeyFactory.buildKey(5, "5"));
        backpack.addItem(KeyFactory.buildKey(42, invalidKey));
        backpack.printItems();
        assertFalse(outContent.toString().contains(invalidKey));
        assertTrue(outContent.toString().contains("5"));
    }

    @Test
    public void testPrintBackpack() {
        Key key = new Key();
        Backpack backpack = new Backpack();
        backpack.addItem(key);
        backpack.printItems();
        assertTrue(outContent.toString().contains(key.getName()));
        assertTrue(outContent.toString().contains("Here are the items in your backpack"));
    }

    @Test
    public void testBackpackViaPlayer() {
        Key key = KeyFactory.buildKey(1, "1");
        Key secondKey = KeyFactory.buildKey(2, "2");
        Player player = new Player();
        player.addItem(key);
        player.addItem(secondKey);
        assertNotNull(player.getItem(key.getName()));
        assertNotNull(player.getItem(secondKey.getName()));
        player.removeItem(key);
        player.removeItem(secondKey);
        assertNull(player.getItem(key.getName()));
        assertNull(player.getItem(secondKey.getName()));
    }

    @Test
    public void testPrintItemsCommand() {
        GameInputProcessor processor = mock(GameInputProcessor.class);
        when(processor.prompt()).thenReturn("inventory");
        when(processor.getNextCommand()).thenCallRealMethod();
        Command command = processor.getNextCommand();
        assertEquals(CommandVerb.INVENTORY, command.getVerb());
    }

}
