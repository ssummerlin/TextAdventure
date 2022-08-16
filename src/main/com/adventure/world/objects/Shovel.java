package main.com.adventure.world.objects;

public class Shovel implements Tangible {

    @Override
    public String getName() {
        return "shovel";
    }

    @Override
    public String getDescription() {
        return "It can probably be used to dig in the ground.";
    }

    @Override
    public Boolean canTake() {
        return true;
    }

    @Override
    public Boolean canUse(Tangible item) {
        return false;
    }

    @Override
    public void useItem(Tangible initiator) {

    }

    @Override
    public void use() {

    }
}
