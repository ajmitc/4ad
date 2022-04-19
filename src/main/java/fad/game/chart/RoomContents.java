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
    SMALL_DRAGONS_LAIR("Small Dragon's Lair");

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
