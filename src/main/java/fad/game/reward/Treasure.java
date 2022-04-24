package fad.game.reward;

/**
 *
 * @author aaron.mitchell
 */
public enum Treasure {
    NOTHING("No treasure found", false),
    D6("d6 GP found", false),
    TWO_D6("2d6 GP found", false),
    SCROLL("A scroll with a random spell found", false),
    GEM("One gem worth 2d6 x 5 GP found", false),
    JEWELRY("One item of jewelry worth 3d6 x 10 GP found", false),
    MAGIC_TREASURE("One random magic item found", true),

    D6_X_D6("d6 x d6 GP found", false),
    TWO_D6_X_D6("2d6 x d6 GP found", false),

    // Magic Treasure
    WAND_OF_SLEEP("Wand of Sleep", true),
    RING_OF_TELEPORTATION("Ring of Teleportation", true),
    FOOLS_GOLD("Fool's Gold", true),
    MAGIC_WEAPON("Magic Weapon", true),
    POTION_OF_HEALING("Potion of Healing", true),
    FIREBALL_STAFF("Fireball Staff", true);
    


    private String name;
    private boolean magic;
    Treasure(String n, boolean magic){
        this.name = n;
        this.magic = magic;
    }

    public String getName() {
        return name;
    }

    public boolean isMagic() {
        return magic;
    }

    @Override
    public String toString() {
        return name;
    }
}
