package fad;

import fad.game.chart.RoomContents;
import fad.game.chart.RoomContentsTable;
import fad.game.dungeon.Room;
import fad.game.dungeon.RoomFactory;
import fad.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void createDungeon(){
        Room entrance = RoomFactory.createEntranceRoom();
        model.getGame().getDungeon().getRooms().add(entrance);

        // TODO Add rooms off all entrance connection points
    }

    public void goThroughDoor(){
        // Roll d66 for room
        Room room = RoomFactory.createRoom();
        // Add room to dungeon
        model.getGame().getDungeon().getRooms().add(room);

        // TODO Move party into room

        // Get Room Contents
        RoomContents roomContents = RoomContentsTable.getRoomContents();
        room.setRoomContents(roomContents);
        handleRoomContents(room);
    }

    public void handleRoomContents(Room room){
        switch(room.getRoomContents()){
            case TREASURE:
                // Roll on Treasure Table
                break;
            case TREASURE_WITH_TRAP:
                // Roll on Traps Table
                // If survive, Roll on Treasure Table
                break;
            case SPECIAL_EVENT_IF_ROOM:
                // If room, Roll on Special Event table
                // Otherwise, Empty
                break;
            case SPECIAL_FEATURE:
                // Empty, but Roll on Special Feature table
                break;
            case VERMIN:
                // Roll on Vermin table
                // If win, Roll on Treasure table
                break;
            case MINION:
                // Roll on minions table
                // If win, roll on Treasure table
                break;
            case MINION_IF_ROOM:
                // if room, roll on minions table.  Then, if win, Roll on Treasure table
                // if corridor, Empty
                break;
            case EMPTY:
                break;
            case WIERD_MONSTER_IF_ROOM:
                // if room, Roll on Weird Monster table.  If win, Roll for leveling up and roll on treasure table
                // if corridor, empty
                break;
            case BOSS:
                // Roll on Boss table.  If win, roll for leveling up and roll on treasure table
                // if room, maybe final Boss
                break;
            case SMALL_DRAGONS_LAIR:
                // if room, this is a Small Dragon's Lair (see boss table).  If win, roll for leveling up and roll on treasure table
                // if corridor, empty
                break;
        }
    }
}
