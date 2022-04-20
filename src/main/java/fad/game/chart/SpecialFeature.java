package fad.game.chart;

public enum SpecialFeature {
    // All wounded heroes recover 1 life the first time they encounter a fountain in an adventure.
    // Further fountains have no effect.
    FOUNTAIN("Fountain"),
    // A hero of your choice gains a +1 on attack rolls against undead monsters or demons.
    // The bonus disappears when the hero kills one such monster.
    BLESSED_TEMPLE("Blessed Temple"),
    // All heroes can change their weapons if they want.
    ARMORY("Armory"),
    // As you enter the room, an eerie glow emanates from a sinister altar.  A random hero is cursed
    // and has -1 on defense rolls.  To break the curse, the hero must either slay a boss alone or
    // enter a Blessed Temple, or have a Blessing spell cast on him by a cleric.
    CURSED_ALTAR("Cursed Altar"),
    // You may leave the statue alone or touch it.
    // If you touch it, roll 1d6.  On 1-3, the statue awakens and attacks your
    // party (level 4 boss; 6 life points; immune to all spells).  If you defeat it, gain 3d6 x 10 GP inside.
    // On 4-6, the statue breaks and you find 3d6 x 10 GP inside.
    STATUE("Statue"),
    // The room contains a puzzle box.  It's level is 1d6.  You may leave it alone or try to solve it.
    // For every failed attempt, the hero trying to solve it loses 1 life.
    // Wizards and Rogues add their level to their puzzle-solving roll.  If the puzzle is solved, the box
    // opens: make a Treasure roll for the contents.
    PUZZLE_ROOM("Puzzle Room");

    private String name;
    SpecialFeature(String n){
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
