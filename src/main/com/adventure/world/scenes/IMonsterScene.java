package main.com.adventure.world.scenes;

import main.com.adventure.world.Monster;

public interface IMonsterScene extends Scene {
    /**
     * Get the scene's monster.
     * @return the scene's monster
     */
    Monster getMonster();

    /**
     * Removes the given monster from the scene (e.g. sets it to null).
     * @param monster - the monster to remove
     */
    void removeMonster(Monster monster);

    /**
     * Called when the player loses the fight.
     */
    void lostFight();

    /**
     * Called when the player wins the fight.
     */
    void wonFight();
}
