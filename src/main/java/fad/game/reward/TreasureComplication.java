package fad.game.reward;

/**
 *
 * @author aaron.mitchell
 */
public enum TreasureComplication {
    WANDERING_MONSTER("An alarm goes off, attracting wandering monsters to the room!"),
    // Trap's level is equal to the number you rolled on the table (3-5).
    // Rogue may try to disarm trap.  If no Rogue, trap attacks a random hero, inflicting 1 wound if he fails to save, and 2 wounds if he rolls a 1
    TRAP("The gold is protected by a trap!"),
    // A ghost (level d3 + 1) protects the gold.  A cleric may try to ban the ghost
    // (roll d6 plus the cleric's level).  The ghost is destroyed if the cleric rolls a number
    // equal to the ghost's level or better.  If no cleric, or cleric fails to ban ghost,
    // all heroes lose 1 life, and ghost disappears.
    GHOST("A ghost protects the gold!");
    


    private String name;
    TreasureComplication(String n){
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
