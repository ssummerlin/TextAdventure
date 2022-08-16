package main.com.adventure.world.objects.doors;

import main.com.adventure.world.objects.Tangible;
import main.com.adventure.world.objects.keys.Key;
import main.com.adventure.world.objects.keys.OmniKey;

import java.util.Arrays;
import java.util.Random;

/**
 * The OmniDoor is a door whose lock is a set of 5 pins. Each pin
 * is either up or down. The OmniDoor can only be opened by an
 * OmniKey who's pins are configured the same as the OmniDoor's pins.

 * If a player tries to open an OmniDoor with an OmniKey and the key is
 * improperly configured, the OmniDoor will randomize its pins.
 *
 * The OmniDoor does have one redeeming quality: you can ask the door
 * to give you a key's first incorrect pin without any consequence.
 */

public class OmniDoor implements Tangible {

    /**
     * The number of pins this door has.
     */
    private static final int pinCount = 5;

    /**
     * Tells us if the door is open or not.
     */
    public boolean isOpen = false;

    /**
     * The pins, represented as booleans (true = up, false = down).
     */
    private final boolean[] pins = new boolean[pinCount];


    /**
     * Creates an OmniDoor with the default lock (all true).
     */
    public OmniDoor() {
        Arrays.fill(pins, true);
    }

    /**
     * This method first checks if the key's pins are correct. If each of the key's
     * pins matches the door's pins at the same index, then the door will update
     * isOpen's state and the following message will be sent to the console:
     *
     *      "The door is unlocked!"
     *
     * If a pin is not correct, then randomizePins is called and the
     * look is immediately stopped.
     *
     * @param key - the key that will be used to attempt to unlock the door
     */
    public void unlock(OmniKey key) {
        //TODO Complete the function
    }

    /**
     * The method will check each pin from the key with the pin
     * in the lock. When the first incorrect pin is found, that
     * index is returned immediately.
     *
     * For example, if the pin at
     * index 1 is incorrect, then this method will return 1 and
     * NOT continue checking subsequent pins.
     *
     * If all pins are correct, then the method will return -1.
     * @param key the key to use to configure the door.
     * @return the index of the first incorrect pin, or -1 if
     * all are correct.
     */
    public int getFirstWrongPin(OmniKey key) {
        //TODO Complete the function
        return 0;
    }

    //Tangible implementation//

    @Override
    public String getName() {
        return "omnidoor";
    }

    @Override
    public String getDescription() {
        return "A door with an auto-randomizing lock";
    }

    @Override
    public Boolean canTake() {
        return false;
    }

    @Override
    public Boolean canUse(Tangible item) {
        return item instanceof OmniKey;
    }

    @Override
    public void useItem(Tangible initiator) {
        if (!(initiator instanceof OmniKey)) {
            if (initiator instanceof Key) {
                System.out.println("Try using and OmniKey instead.");
            }
            return;
        }

        unlock((OmniKey) initiator);
    }

    @Override
    public void use() {

    }

    private void randomizePins() {
        Random random = new Random();
        for (int i = 0; i < pinCount; i++) {
            pins[i] = random.nextBoolean();
        }
    }
}
