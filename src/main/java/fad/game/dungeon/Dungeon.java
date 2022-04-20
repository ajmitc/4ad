package fad.game.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private List<Room> rooms = new ArrayList<>();

    public Dungeon(){
        rooms.add(RoomFactory.createEntranceRoom());
    }

    /**
     * For every door and hallway in startingRoom, create another room connected to it
     * @param startingRoom 
     */
    public void addConnectingRooms(Room startingRoom){
        for (RoomSpace roomSpace: startingRoom.getAllSpaces())){
            if (roomSpace.isConnectingSpace() && !roomSpace.hasConnectingRoom()){
                Room connectingRoom = RoomFactory.createRoom();
                roomSpace.setConnectingRoom(connectingRoom);
                for (RoomSpace cRoomSpace: connectingRoom.getAllSpaces()){
                    if (cRoomSpace.isConnectingSpace() && !cRoomSpace.hasConnectingRoom()){
                        cRoomSpace.setConnectingRoom(startingRoom);
                    }
                }
            }
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
