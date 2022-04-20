package fad.game.dungeon;

/**
 *
 * @author aaron.mitchell
 */
public class RoomSpace {
    private RoomSpaceType type;
    private Room connectingRoom;

    public RoomSpace(RoomSpaceType type){
        this.type = type;
    }

    public RoomSpaceType getType() {
        return type;
    }

    public boolean isConnectingSpace(){
        return type == RoomSpaceType.DOOR || type == RoomSpaceType.HALLWAY;
    }

    public boolean hasConnectingRoom(){
        return connectingRoom != null;
    }

    public Room getConnectingRoom() {
        return connectingRoom;
    }

    public void setConnectingRoom(Room connectingRoom) {
        this.connectingRoom = connectingRoom;
    }
}
