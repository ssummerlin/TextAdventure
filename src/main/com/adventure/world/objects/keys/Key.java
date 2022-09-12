package main.com.adventure.world.objects.keys;

import main.com.adventure.world.objects.Tangible;

/**
 * A key opens a locked door. More specifically, keys work only on doors that share their level.
 * For example, if a key is level 1, it can only open doors that are also level 1.
 *
 * A key's level cannot change once the object is instantiated. You should create the following constructors that take
 * the following parameters:
 * 1. without any inputs (i.e. default parameters)
 * 2. a level (int)
 * 3. a level (int) and a name (string)
 *
 * The default values for a door are level = 1 and name = "key"
 */

public class Key implements Tangible {

    private final int level;
    private final String name;

    //TODO variable for level and name needed here

    //TODO Add default (i.e. no params) constructor here

    /**
     * Checks the status of the hole.
     * identifies level of the key.
     */

    public Key() {
        this.name = "key";
        this.level = 1;

    }
    /**
     * @param level - level of player
     * identifies level of the key.
     */
    //TODO add constructor that takes a level, and saves it
    public Key(int level) {
        this.level = level;
        this.name = "key";

    }
    /**
     * @param level - level of player
     * @param name - String name of player
     */
    //TODO add constructor that takes a level and name, and saves it
    public Key(int level, String name) {
        this.level = level;
        this.name = name;




    }
    public int getLevel() {
        return this.level;

        //TODO Fix this so it references the level property instead of 0
    }

    //TODO Fix this so it references the name property instead of "key"
    @Override
    public String getName() {
        return this.name;
    }








    //******IGNORE THE CODE BELOW******//


    @Override
    public Boolean canTake() {
        return true;
    }

    @Override
    public Boolean canUse(Tangible item) {
        return false;
    }

    @Override
    public void useItem(Tangible initiator) { /* intentionally left blank */ }

    @Override
    public void use() {
        System.out.println(getName() + " doesn't much be itself. Try using it on a door");
    }

    @Override
    public String getDescription() {
        return "A key that opens a door";
    }


}
