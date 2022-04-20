package fad.game.chart;

/**
 *
 * @author aaron.mitchell
 */
public enum Treasure {
    NOTHING("No treasure found"),
    D6("d6 GP found"),
    TWO_D6("2d6 GP found"),
    SCROLL("A scroll with a random spell found"),
    GEM("One gem worth 2d6 x 5 GP found"),
    JEWELRY("One item of jewelry worth 3d6 x 10 GP found"),
    MAGIC_TREASURE("One random magic item found"),

    // Magic Treasure
    WAND_OF_SLEEP("Wand of Sleep"),
    RING_OF_TELEPORTATION("Ring of Teleportation"),
    FOOLS_GOLD("Fool's Gold"),
    MAGIC_WEAPON("Magic Weapon"),
    POTION_OF_HEALING("Potion of Healing"),
    FIREBALL_STAFF("Fireball Staff");


    private String name;
    Treasure(String n){
        this.name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
