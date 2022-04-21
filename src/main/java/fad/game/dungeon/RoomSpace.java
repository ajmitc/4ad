package fad.game.dungeon;

/**
 *
 * @author aaron.mitchell
 */
public class RoomSpace {
    private RoomSpaceType type;
    private Room connectingRoom;
    private int x, y;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
