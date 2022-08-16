package com.adventure;

import main.com.adventure.GameInputProcessor;
import main.com.adventure.player.Player;
import main.com.adventure.settings.AppSettings;
import main.com.adventure.settings.Command;
import main.com.adventure.settings.CommandConstants;
import main.com.adventure.world.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MT3 {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrompt() {
        GameInputProcessor processor = new GameInputProcessor();
        String input = "hello world";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);

        assertEquals(input, processor.prompt());
    }

    @Test
    public void testPrompt2() {
        GameInputProcessor processor = new GameInputProcessor();
        String input = "Another hello world";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);

        assertEquals(input, processor.prompt());
    }

    @Test
    public void checkMoveInputWest() {
        if (AppSettings.story.ordinal() >= AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        GameInputProcessor processor = mock(GameInputProcessor.class);
        when(processor.prompt()).thenReturn("move west");
        when(processor.getNextCommand()).thenCallRealMethod();

        Command command = processor.getNextCommand();
        assertEquals(CommandConstants.MOVE, command.getVerb());
        assertTrue(command.getObjectName().equalsIgnoreCase("west"));
    }

    @Test
    public void checkMoveInputEast() {
        if (AppSettings.story.ordinal() >= AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        GameInputProcessor processor = mock(GameInputProcessor.class);
        String input = "move east";

        when(processor.prompt()).thenReturn(input);
        when(processor.getNextCommand()).thenCallRealMethod();
        Command command = processor.getNextCommand();

        assertEquals(CommandConstants.MOVE, command.getVerb());
        assertTrue(command.getObjectName().equalsIgnoreCase("east"));
    }

    @Test
    public void testInvalidMoveInput() {
        if (AppSettings.story.ordinal() >= AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        GameInputProcessor processor = mock(GameInputProcessor.class);

        when(processor.prompt()).thenReturn("move");
        when(processor.getNextCommand()).thenCallRealMethod();
        Command command = processor.getNextCommand();

        assertEquals(CommandConstants.MOVE, command.getVerb());
        assertEquals("", command.getObjectName().toLowerCase());
    }

    @Test
    public void testUseInput() {
        if (AppSettings.story.ordinal() >= AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        String verb = CommandConstants.USE;
        String object = "key";
        GameInputProcessor processor = mock(GameInputProcessor.class);
        
        when(processor.prompt()).thenReturn(verb + " " + object);
        when(processor.getNextCommand()).thenCallRealMethod();

        Command command = processor.getNextCommand();

        assertEquals(verb, command.getVerb());
        assertEquals(object, command.getObjectName().toLowerCase());
    }

    @Test
    public void checkSimpleInput() {
        if (AppSettings.story.ordinal() >= AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        GameInputProcessor processor = mock(GameInputProcessor.class);

        when(processor.prompt()).thenReturn(CommandConstants.LOOK + " other content that should not be included");
        when(processor.getNextCommand()).thenCallRealMethod();
        Command command = processor.getNextCommand();

        assertEquals(CommandConstants.LOOK, command.getVerb());
        assertEquals("", command.getObjectName());
    }

    @Test
    public void testPlayerMovementInvalid() {
        Player player = new Player();

        int oldValue = player.getCurrentLocation();

        assertFalse(player.move(Direction.EAST, false));
        assertEquals(player.getCurrentLocation(), oldValue);
        assertEquals("EAST is not a valid direction".toLowerCase(), outContent.toString().trim().toLowerCase());
    }

    @Test
    public void testPlayerMovementWest() {
        Player player = new Player();

        int oldValue = player.getCurrentLocation();

        assertTrue(player.move(Direction.WEST, true));
        assertEquals(oldValue, player.getCurrentLocation() + 1);
    }

    @Test
    public void testPlayerMovementEast() {
        Player player = new Player();

        int oldValue = player.getCurrentLocation();

        assertTrue(player.move(Direction.EAST, true));
        assertEquals(oldValue, player.getCurrentLocation() - 1);
    }

}
