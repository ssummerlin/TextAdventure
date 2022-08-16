package com.adventure;

import main.com.adventure.CombatController;
import main.com.adventure.player.Player;
import main.com.adventure.world.objects.Weapon;
import main.com.adventure.world.Monster;
import main.com.adventure.world.scenes.SceneDescriptionFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MT7 {

    @Test
    public void testCombatSimulator() {
        Player player = new Player();
        player.setHealth(10);

        Monster monster = new Monster("Ogre", 5, 10);
        Weapon noWeapon = new Weapon("bare knuckles", 3);
        player.setWeapon(noWeapon);
        CombatController controller = new CombatController(player, monster);
        controller.autosimulateCombat();

        assertTrue(controller.isPlayerDefeated());

        controller.reset();
        assertEquals(10, player.getHealth());
        assertEquals(10, monster.getHealth());

        Monster weakMonster = new Monster("bat", 1, 10);
        controller = new CombatController(player, weakMonster);
        controller.autosimulateCombat();

        assertFalse(controller.isPlayerDefeated());

        controller.reset();
        assertEquals(10, player.getHealth());
        assertEquals(10, monster.getHealth());

        Weapon bigSword = new Weapon("sword", 10);
        player.setWeapon(bigSword);

        controller.autosimulateCombat();
        assertFalse(controller.isPlayerDefeated());
    }

    @Test
    public void testReadFile() throws IOException {
        SceneDescriptionFileReader reader = new SceneDescriptionFileReader();
        String result = reader.printTextFromFile("TestScene.txt");
        assertEquals("Roses are red\n" +
                "Violets are blue\n" +
                "Unexpected bracket\n" +
                "On line 32".trim(), result.trim());
    }

    @Test
    public void testReadFile2() throws IOException {
        SceneDescriptionFileReader reader = new SceneDescriptionFileReader();
        String result = reader.printTextFromFile("TestScene2.txt");
        assertEquals("Two roads diverged in a yellow wood,\n" +
                "And sorry I could not travel both\n" +
                "And be one traveler, long I stood\n" +
                "And looked down one as far as I could\n" +
                "To where it bent in the undergrowth;\n" +
                "\n" +
                "Then took the other, as just as fair,\n" +
                "And having perhaps the better claim,\n" +
                "Because it was grassy and wanted wear;\n" +
                "Though as for that the passing there\n" +
                "Had worn them really about the same,\n" +
                "\n" +
                "And both that morning equally lay\n" +
                "In leaves no step had trodden black.\n" +
                "Oh, I kept the first for another day!\n" +
                "Yet knowing how way leads on to way,\n" +
                "I doubted if I should ever come back.\n" +
                "\n" +
                "I shall be telling this with a sigh\n" +
                "Somewhere ages and ages hence:\n" +
                "Two roads diverged in a wood, and I\n" +
                "I took the one less traveled by,\n" +
                "And that has made all the difference.".trim(), result.trim());
    }
}
