package fad.game.dungeon;

import fad.util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aaron.mitchell
 */
public class RoomFactory {
    public static Room createRoom(){
        int v = Util.rolld66();
        String[] def = getRoomDefinition(v);
        Room room = def2Room(def);
        // TODO Set corridor value
        return room;
    }

    public static Room createEntranceRoom(){
        int v = Util.roll();
        String[] def = getEntranceRoomDefinition(v);
        Room room = def2Room(def);
        // TODO Set corridor value
        return room;
    }

    /**
     * #: wall
     * d: door
     *  : open space
     * 
     * @param id
     * @return 
     */
    private static String[] getEntranceRoomDefinition(int id){
        switch(id){
            case 1:
                return new String[]{
                    "   ^   ",
                    "v  v  v",
                };
            case 2:
                return new String[]{
                        "  ^  ",
                        "<    ",
                        "    v",
                        "## # ",
                        "## #",
                };
        }
        return new String[]{};
    }

    private static String[] getRoomDefinition(int id){
        switch(id){
            case 11:
                return new String[]{
                    ""
                };
        }
        return new String[]{};
    }

    private static Room def2Room(String[] def){
        Room room = new Room();
        for (int r = 0; r < def.length; ++r){
            List<RoomSpace> row = new ArrayList<>();
            room.getSpaces().add(row);

            for (int c = 0; c < def[r].length(); ++c){
                RoomSpace space = RoomSpace.OPEN;
                switch(def[r].charAt(c)){
                    case '#':
                        space = RoomSpace.WALL;
                        break;
                    case 'd':
                        space = RoomSpace.DOOR;
                        break;
                }
                row.add(space);
            }
        }
        return room;
    }
}
