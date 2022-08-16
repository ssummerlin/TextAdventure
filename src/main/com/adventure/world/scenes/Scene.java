package main.com.adventure.world.scenes;

import main.com.adventure.world.objects.Tangible;

import java.util.List;

public interface Scene {
    /**
     * The user-facing description of the scene.
     * @return - the scene's description.
     * @throws SceneDescriptionNotFoundException - the scene's description is not found.
     */
    String getDescription() throws SceneDescriptionNotFoundException;

    /**
     * Builds the user-facing string of the possible directions for a given scene.
     * @return - the user-facing string of possible directions
     */
    List<String> getPossibleDirections();

    /**
     * Finds the item in the scene based on the itemName.
     * @param itemName - the name of the item.
     * @return If it exists, the item. Othwerise, null.
     */
    Tangible getItem(String itemName);

    /**
     * Removes the item from the scene, like when the player takes it.
     * @param item - the item to be removed.
     */
    void removeItem(Tangible item);

    /**
     * Digs at the scene.
     */
    void dig();
}
