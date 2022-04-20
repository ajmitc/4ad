package fad.game.chart;

public enum SpecialEvent {
    // A ghost passes through the party.  All heroes must save versus level 4 fear or lose 1 life.
    // A cleric adds his level to his roll.
    GHOST("Ghost"),
    // A Wandering monster attacks the party.
    // Roll 1d6:
    // 1-3: Roll on vermin table
    // 4: Roll on minions table
    // 5: Roll on Weird Monsters table
    // 6: Roll on Boss table (cannot be final boss)
    // Re-roll any small dragons
    WANDERING_MONSTER("Wandering Monster"),
    // A lady in white appears and asks the party to complete a quest.  If you accept,
    // roll on the Quest table.  If you refuse, ignore any further appearances of the lady in white
    // in the adventure
    LADY_IN_WHITE("Lady in white"),
    // Roll on the traps table
    TRAP("Trap!"),
    // You meet a wandering healer.  He will heal 1 life point for every 10 GP you spend.
    // You may heal as much as you can afford.  He only appears once per game.  Re-roll subsequent appearances.
    WANDERING_HEALER("Wandering Healer"),
    // You meet a wandering alchemist.  He will sell you 1 potion of healing per party member (50 GP each) or
    // a single dose of blade poison (30 GP).
    // The potion of healing can be drank of a single hero at any time to restore all lost life points.
    // The blade poison can be applied to an arrow or slashing weapon to give +1 on Attack rolls against
    // the first monster you fight.  Poison will not work against undead, demons, blobs, automatons, or living statues.
    // You can only meet a wandering alchemist once per game.  If you meet him again, treat this as a TRAP
    // result and roll on the Trap table.
    WANDERING_ALCHEMIST("Wandering Alchemist");

    private String name;
    SpecialEvent(String n){
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
