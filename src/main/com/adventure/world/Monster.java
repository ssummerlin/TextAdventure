package main.com.adventure.world;

public class Monster {

    private String name;
    private int power;
    private int health;

    /**
     * A monster that is fought by the player.
     * @param name - the user-displayed name.
     * @param power - the power, or amount of damage inflicted which each hit.
     * @param health - the full health of the monster.
     */
    public Monster(String name, int power, int health) {
        this.name = name;
        this.power = power;
        this.health = health;
    }

    public String getName() {
        return name;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
