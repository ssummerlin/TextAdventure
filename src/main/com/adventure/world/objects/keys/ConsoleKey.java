package main.com.adventure.world.objects.keys;

import main.com.adventure.world.objects.TangibleListener;

public class ConsoleKey extends Key {

    TangibleListener listener;

    /**
     * Creates a console key. This key is not a key you can take, but it's something you can use.
     * The key acts as a remote, where the TangibleListener is in charge of reacting
     * to the use() method and changing the environment when it is called.
     * @param l - receives a callback when this key is used.
     */
    public ConsoleKey(TangibleListener l) {
        super();
        this.listener = l;
    }

    @Override
    public String getName() {
        return "console";
    }

    /**
     * Uses the key, as if the player was interacting with the console.
     */
    @Override
    public void use() {
        super.use();
        listener.tangibleUsed(this);
    }
}
