package fad.monster;

/**
 *
 * @author aaron.mitchell
 */
public enum MonsterType {
    // Vermin (don't give XP, do not need to track kills)
    RATS("Rats", true, false),
    VAMPIRE_BATS("Vampire Bats", true, false),
    GOBLIN_SWARMLINGS("Goblin Swarmlings", true, false),
    GIANT_CENTIPEDES("Giant Centipedes", true, false),
    VAMPIRE_FROGS("Vampire Frogs", true, false),
    SKELETAL_RATS("Skeletal Rats", true, false);

    private String name;
    private boolean vermin;
    private boolean boss;
    MonsterType(String n, boolean vermin, boolean boss){
        this.name = n;
        this.vermin = vermin;
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public boolean isVermin() {
        return vermin;
    }

    public boolean isBoss() {
        return boss;
    }

    @Override
    public String toString() {
        return name;
    }
}
