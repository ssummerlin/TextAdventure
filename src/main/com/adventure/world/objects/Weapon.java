package main.com.adventure.world.objects;

public class Weapon implements Tangible {

    private String name;
    private int power;

    /**
     * Creates a weapon with the name and power.
     * @param name - the name of the weapon
     * @param power - the power that the weapon provides to the player when equipped.
     */
    public Weapon(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "A good looking sword";
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

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
