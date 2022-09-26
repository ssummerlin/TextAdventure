package main.com.adventure.world.objects.keys;

public class KeyFactory {



    /**
     * Creates a key based on the given params.
     * @param level - the key's level
     * @param name - the key's name
     * @return a key
     */
    public static Key buildKey(int level, String name) {
        Key key = new Key(level, name);



        //TODO Pass level and name into the key constructor when the proper constructor is built

        return key;
    }
}
