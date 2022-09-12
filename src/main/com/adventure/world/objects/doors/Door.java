package main.com.adventure.world.objects.doors;

import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.keys.Key;

/**
 * Doors can be open or locked. That state should be maintained in this class.
 * A door's level cannot be changed once the class has been created. You should create multiple constructors that allow
 * the Door to be created:
 * 1. without any inputs (i.e. default parameters)
 * 2. a level and an open/locked state
 *
 * The default values for a door are level = 1 and isOpen = false
 */

public class Door implements Tangible {
    public int level;
    private boolean isOpen;

    /**
     * Sprint 2 Module 3.
     * level - door weight
     * Door - function of door
     */
    public Door() {
        this.level = 1;
        this.isOpen = false;


    }
    /**
     *  Boolean function for the door.
     * @param isOpen - state of door.
     * @param level - players ability to open door.
     */
    public Door(boolean isOpen, int level) {
        this.level = level;
        this.isOpen = isOpen;
    }


    //TODO Add a level property
    //TODO Add a default (i.e. no params) constructor here
    //TODO Add a constructor that takes an isOpen and level and saves both




    private boolean isKeyValid(Key key) {
        //TODO Update doorLevel so it references the level of this door


        return key != null && key.getLevel() == this.level;
    }
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Sets the isOpen state.
     * @param newOpenState - the value to save to the isOpen property
     */
    public void setIsOpen(boolean newOpenState) {
        this.isOpen = newOpenState;
    }






    //******IGNORE THE CODE BELOW******//

    @Override
    public String getName() {
        return "door";
    }

    @Override
    public Boolean canTake() {
        return false;
    }

    @Override
    public Boolean canUse(Tangible item) {
        Key key = (Key) item;
        return isKeyValid(key);
    }

    @Override
    public void useItem(Tangible initiator) {
        if (this.canUse(initiator)) {
            setIsOpen(true);
            System.out.println("Door is now open");
        } else {
            System.out.println("That didn't work on the door");
        }
    }

    @Override
    public void use() {
        if (isOpen()) {
            System.out.println("It's unlocked. You can walk on through if you like.");
        } else {
            System.out.println("It's locked. It may need a key.");
        }
    }

    @Override
    public String getDescription() {
        if (isOpen()) {
            return "It's an open door";
        } else {
            return "It's a locked door";
        }
    }


}
