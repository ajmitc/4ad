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
        // Set corridor value
        if (v == 3 || v == 5)
            room.setCorridor(true);
        return room;
    }

    /**
     * #: wall
     *  : open type
     * d: door (connection point)
     * h: hallway (connection point)
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
                    "# ## ## #",
                    "#       #",
                    "####h####",
                };
            case 4:
                return new String[]{
                        "#h###h#",
                        "# ### #",
                        "#     #",
                        "## h ##",
                };
            case 5:
                return new String[]{
                        "##h##",
                        "## ##",
                        "h   h",
                        "## ##",
                        "##h##",
                };
            case 6:
                return new String[]{
                        "#######",
                        "h     h",
                        "###  ##",
                        "##   ##",
                        "##   ##",
                        "###d ##",
                };
        }
        return new String[]{};
    }

    private static String[] getRoomDefinition(int id){
        switch(id){
            case 11:
                return new String[]{
                        "###",
                        "# d",
                        "# #",
                        "d #",
                        "# #",
                        "#h#",
                };
            case 12:
                return new String[]{
                        "#d#",
                        "# #",
                        "# #",
                        "# #",
                        "#d#",
                };
            case 13:
                return new String[]{
                        "##d##",
                        "d   #",
                        "### #",
                        "### #",
                        "#   #",
                        "# ###",
                        "#   h",
                        "#####",
                };
            case 14:
                return new String[]{
                        "###",
                        "h d",
                        "# #",
                        "# #",
                        "# #",
                        "# #",
                        "d h",
                        "###",
                };
            case 15:
                return new String[]{
                        "#d##",
                        "#  ###",
                        "#    #",
                        "d    #",
                        "####d#",
                };
            case 16:
                return new String[]{
                        "##d##",
                        "#   #",
                        "#   #",
                        "## ##",
                        " # # ",
                        " #h# ",
                };
            case 21:
                return new String[]{
                        "#####",
                        "#   #",
                        "#   #",
                        "#   #",
                        "##d##",
                };
            case 22:
                return new String[]{
                        "##d##",
                        "#   #",
                        "d   #",
                        "#   #",
                        "##h##",
                };
            case 23:
                return new String[]{
                        "   #####",
                        "####   #",
                        "d      d",
                        "####   #",
                        "   #   #",
                        "   #####",
                };
            case 24:
                return new String[]{
                        " #d# ",
                        "## ##",
                        "d   #",
                        "#   #",
                        "## ##",
                        " #d# ",
                };
            case 25:
                return new String[]{
                        "   #####",
                        "####   #",
                        "h      d",
                        "####   #",
                        "   #####",
                };
            case 26:
                return new String[]{
                        "###",
                        "d #",
                        "# d",
                        "###",
                };
            case 31:
                return new String[]{
                        " ##d#",
                        " #  #",
                        " #  #",
                        "#   #",
                        "# ###",
                        "#d#  ",
                };
            case 32:
                return new String[]{
                        " ####",
                        " #  d",
                        " # ##",
                        "## ##",
                        "d   d",
                        "#####",
                };
            case 33:
                return new String[]{
                        "#d#",
                        "# #",
                        "d #",
                        "# #",
                        "###",
                };
            case 34:
                return new String[]{
                        " #d#",
                        "## ##",
                        "#   #",
                        "#   #",
                        "## ##",
                        " #d# ",
                };
            case 35:
                return new String[]{
                        "#h#",
                        "# #####",
                        "#     #",
                        "##    #",
                        " #    #",
                        " ######",
                };
            case 36:
                return new String[]{
                        "#####",
                        "##  d",
                        "## ##",
                        "#  ###",
                        "d    #",
                        "#    #",
                        "## ###",
                        "d  ###",
                        "######",
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
