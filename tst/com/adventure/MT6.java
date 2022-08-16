package com.adventure;

import main.com.adventure.GameInputProcessor;
import main.com.adventure.settings.AppSettings;
import main.com.adventure.settings.Command;
import main.com.adventure.settings.CommandVerb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MT6 {

    GameInputProcessor processor;

    @BeforeEach
    public void setup() {
        processor = mock(GameInputProcessor.class);
        when(processor.getNextCommand()).thenCallRealMethod();
    }

    @Test
    public void testCommandMove() {
        if (AppSettings.story.ordinal() < AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        when(processor.prompt()).thenReturn("move west");

        Command command = processor.getNextCommand();
        assertEquals(CommandVerb.MOVE, command.getVerb());
        assertTrue(command.getObjectName().equalsIgnoreCase("west"));

        when(processor.prompt()).thenReturn("move east");
        command = processor.getNextCommand();
        assertEquals(CommandVerb.MOVE, command.getVerb());
        assertTrue(command.getObjectName().equalsIgnoreCase("east"));
    }

    @Test
    public void testCommandUse() {
        if (AppSettings.story.ordinal() < AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        when(processor.prompt()).thenReturn("use key");
        Command command = processor.getNextCommand();
        assertEquals(CommandVerb.USE, command.getVerb());
        assertEquals("key", command.getObjectName());
    }

    @Test
    public void testCommandHelp() {
        if (AppSettings.story.ordinal() < AppSettings.Story.MT6_TestDirections.ordinal()) {
            return;
        }

        when(processor.prompt()).thenReturn("help");
        Command command = processor.getNextCommand();
        assertEquals(CommandVerb.HELP, command.getVerb());
        assertEquals("", command.getObjectName());
    }

}