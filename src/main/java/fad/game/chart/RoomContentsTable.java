package fad.game.chart;

import fad.util.Util;

/**
 *
 * @author aaron.mitchell
 */
public class RoomContentsTable {
    public static RoomContents getRoomContents(){
        int v = Util.roll2d6();
        switch(v){
            case 2 -> {
                return RoomContents.TREASURE;
            }
            case 3 -> {
                return RoomContents.TREASURE_WITH_TRAP;
            }
            case 4 -> {
                return RoomContents.SPECIAL_EVENT_IF_ROOM;
            }
            case 5 -> {
                return RoomContents.SPECIAL_FEATURE;
            }
            case 6 -> {
                return RoomContents.VERMIN;
            }
            case 7 -> {
                return RoomContents.MINION;
            }
            case 8 -> {
                return RoomContents.MINION_IF_ROOM;
            }
            case 9 -> {
                return RoomContents.EMPTY;
            }
            case 10 -> {
                return RoomContents.WIERD_MONSTER_IF_ROOM;
            }
            case 11 -> {
                return RoomContents.BOSS;
            }
            case 12 -> {
                return RoomContents.SMALL_DRAGONS_LAIR;
            }
        }
        return null;
    }

    /**
     * Roll on this table when searching a seemingly empty room
     * @param isCorridor
     * @return 
     */
    public static RoomContents searchEmptyRoom(boolean isCorridor){
        int v = Util.roll();
        if (isCorridor)
            v -= 1;
        if (v <= 1)
            return RoomContents.WANDERING_MONSTER;
        if (v <= 4)
            return RoomContents.EMPTY;
        return RoomContents.CHOOSE_CLUE_DOOR_TREASURE;
    }
}
