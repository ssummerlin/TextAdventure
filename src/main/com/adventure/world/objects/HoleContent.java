package main.com.adventure.world.objects;

import main.com.adventure.world.objects.keys.Key;

public class HoleContent {

    /**
     * Checks the status of the hole.
     * key - item in the hole
     * content - items in the hole
     */

    private boolean isCovered = true;

    /**
     * Checks the status of the hole.
     */
    public HoleContent(){

    }

    /**
     * Checks the status of the hole.
     * @param isCovered - status of the hole
     */
    public void setIsCovered(boolean isCovered) {
        this.isCovered = isCovered;

    }

    public boolean isCovered() {
        return this.isCovered;

    }
    public Key getKey() {

        return null;
    }


}
