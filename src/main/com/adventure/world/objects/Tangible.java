package main.com.adventure.world.objects;

/**
 * Tangible is an interface that all objects that the player can interact with must implement.
 */

public interface Tangible {
    /**
     * The user-facing name of the object.
     * @return - the user-facing name string.
     */
    String getName();

    /**
     * The user-facing description that the user will see when they want to look at the object.
     * @return - a user-facing description string.
     */
    String getDescription();

    /**
     * If the item can be taken by the player or not.
     * @return - true if it can be taken. Otherwise, false.
     */
    Boolean canTake();

    /**
     * Informs if this object can be used with the given object (e.g. a key can be used with a door, but not a frog).
     * @param item - the item that this object wants to interact with.
     * @return - true if the items can interact. Otherwise, false.
     */
    Boolean canUse(Tangible item);

    /**
     * Use this item with the given item.
     * @param initiator - the item that this item will interact with.
     */
    void useItem(Tangible initiator);

    /**
     * Use the item by itself.
     */
    void use();
}
