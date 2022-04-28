package fad.game.monster;

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
    SKELETAL_RATS("Skeletal Rats", true, false),
    
    // Minions (Track kills.  Surviving 10 encounters gives you 1 XP roll)
    // Crushing weapons get +1 attack roll.  Arrows are -1 attack roll.  Never test morale
    SKELETONS("Skeletons", false, false),
    // Crushing weapons get +1 attack roll.  Arrows are -1 attack roll.  Never test morale
    ZOMBIES("Zombies", false, false),
    GOBLINS("Goblins", false, false),
    HOBGOBLINS("Hobgoblins", false, false),
    ORCS("Orcs", false, false),
    TROLLS("Trolls", false, false),
    FUNGI_FOLK("Fungi Folk", false, false),
    
    // Bosses (Defeating a boss gives 1 XP roll)
    MUMMY("Mummy", false, true),
    ORC_BRUTE("Orc Brute", false, true),
    OGRE("Ogre", false, true),
    MEDUSA("Medusa", false, true),
    CHAOS_LORD("Chaos Lord", false, true),
    SMALL_DRAGON("Small Dragon", false, true),
    
    // Weird Monsters (Equivalent to Bosses. Defeating one gives 1 XP roll)
    MINOTAUR("Minataur", false, true),
    IRON_EATER("Iron Eater", false, true),
    CHIMERA("Chimera", false, true),
    CATOBLEPAS("Catoblepas", false, true),
    GIANT_SPIDER("Giant Spider", false, true),
    INVISIBLE_GREMLINS("Invisible Gremlins", false, true);

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

    public boolean isMinion() {
        return !boss;
    }

    public boolean isSkeleton(){
        return this == SKELETAL_RATS || this == SKELETONS;
    }

    @Override
    public String toString() {
        return name;
    }
}
