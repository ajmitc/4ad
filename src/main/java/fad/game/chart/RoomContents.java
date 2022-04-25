package fad.game.chart;

/**
 *
 * @author aaron.mitchell
 */
public enum RoomContents {
    TREASURE("Treasure"), // Roll on the Treasure table
    TREASURE_WITH_TRAP("Treasure protected by a trap"), // Roll on both the trap and treasure tables
    SPECIAL_EVENT_IF_ROOM("Special Event"),
    SPECIAL_FEATURE("Special Feature"),
    VERMIN("Vermins"),
    MINION("Minions"),
    MINION_IF_ROOM("Minions"),
    EMPTY("Empty"),
    WIERD_MONSTER_IF_ROOM("Wierd Monster"),
    BOSS("Boss"),
    SMALL_DRAGONS_LAIR("Small Dragon's Lair"),
    
    WANDERING_MONSTER("Wandering Monster"),
    // Roll 1d6.  On a 6, it is a safe shortcut out of the dungeon.
    // Heroes may choose to "spy" in room before entering it.
    // Any GP are doubled.
    // Any monsters will be surprised by heroes (reduce their level by 1 - to a minimum of 1 - in first turn of combat)
    SECRET_DOOR("Secret Door"),
    // Hidden Treasure - Roll on Hidden Treasure Complication Table.  3d6 x 3d6 GP
    CHOOSE_CLUE_DOOR_TREASURE("Choose a clue, a secret door, or a hidden treasure");

    private String name;
    RoomContents(String n){
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
