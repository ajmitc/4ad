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
     * ^: door going up
     * v: door going down 
     * <: door going left
 >: door going right
  : open type
 c: connection point to another room
     * 
     * @param id
     * @return 
     */
    private static String[] getEntranceRoomDefinition(int id){
        switch(id){
            case 1:
                return new String[]{
                    "#d##d##d#",
                    "#       #",
                    "#       #",
                    "####d####",
                };
            case 2:
                return new String[]{
                    "  #h#",
                    "#d# ###",
                    "#     #",
                    "d     #",
                    "#     #",
                    "###d###",
                };
            case 3:
                return new String[]{
                    "#h##h##h#",
                    "#       #",
                    "#       #",
                    "####h####",
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
        for (int r = def.length - 1; r >= 0; --r){
            List<RoomSpace> row = new ArrayList<>();
            room.getSpaces().add(row);

            for (int c = 0; c < def[r].length(); ++c){
                RoomSpaceType type = RoomSpaceType.OPEN;
                switch(def[r].charAt(c)){
                    case '#':
                        type = RoomSpaceType.WALL;
                        break;
                    case 'd':
                        type = RoomSpaceType.DOOR;
                        break;
                    case 'h':
                        type = RoomSpaceType.HALLWAY;
                        break;
                }
                row.add(new RoomSpace(type));
            }
        }
        return room;
    }
}
