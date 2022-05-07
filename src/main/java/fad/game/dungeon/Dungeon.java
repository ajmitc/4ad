package fad.game.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dungeon {
    public static final int ENTRANCE_X = 100;
    public static final int ENTRANCE_Y = 100;

    private List<Room> rooms = new ArrayList<>();

    public Dungeon(){
        rooms.add(RoomFactory.createEntranceRoom());
        rooms.get(0).assignLocationCoordinates(ENTRANCE_X, ENTRANCE_Y);
    }

    /**
     * For every door and hallway in startingRoom, create another room connected to it
     * @param startingRoom 
     */
    public void addConnectingRooms(Room startingRoom){
        for (RoomSpace roomSpace: startingRoom.getAllSpaces()){
            if (roomSpace.isConnectingSpace() && !roomSpace.hasConnectingRoom()){
                boolean roomAdded = false;
                while (!roomAdded){
                    Room connectingRoom = RoomFactory.createRoom();
                    for (RoomSpace cRoomSpace: connectingRoom.getAllSpaces()){
                        if (cRoomSpace.isConnectingSpace() && !cRoomSpace.hasConnectingRoom()){
                            roomAdded = connectRooms(startingRoom, roomSpace, connectingRoom, cRoomSpace);
                            if (roomAdded)
                                break;
                        }
                    }
                }
            }
        }
    }

    private boolean connectRooms(Room startingRoom, RoomSpace startingRoomSpace, Room connectingRoom, RoomSpace connectingRoomSpace){
        // Try to fit the rooms together, moving and turning the connecting room as necessary
        // The starting room cannot move
        boolean roomAdded = false;
        double rotation = 0.0;
        while(!roomAdded){
            final int offsets[][] = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
            };
            for (int i = 0; i < offsets.length; ++i){
                int[] o = offsets[i];
                connectingRoom.assignLocationCoordinates(startingRoomSpace.getX() + o[0], startingRoomSpace.getY() + o[1]);
                boolean overlaps = false;
                for (Room room: rooms){
                    overlaps = roomsOverlap(room, connectingRoom);
                    if (overlaps){
                        break;
                    }
                }
                if (!overlaps){
                    startingRoomSpace.setConnectingRoom(connectingRoom);
                    connectingRoomSpace.setConnectingRoom(startingRoom);
                    rooms.add(connectingRoom);
                    roomAdded = true;
                    break;
                }
            }
            if (!roomAdded){
                // Try rotating the room
                rotation += 90.0;
                if (rotation >= 360.0){
                    break;
                }
                rotateRoom(connectingRoom, rotation, connectingRoomSpace);
            }
        }
        return roomAdded;
    }

    private boolean roomsOverlap(Room startingRoom, Room connectingRoom){
        boolean overlap = false;
        for (RoomSpace startingRoomSpace: startingRoom.getAllSpaces()){
            for (RoomSpace connectingRoomSpace: connectingRoom.getAllSpaces()){
                if (startingRoomSpace.getX() == connectingRoomSpace.getX() && startingRoomSpace.getY() == connectingRoomSpace.getY()){
                    overlap = true;
                    break;
                }
            }
            if (overlap)
                break;
        }
        return overlap;
    }

    private void rotateRoom(Room room, double rotationDegrees, RoomSpace centerSpace){
        int centerX = centerSpace.getX();
        int centerY = centerSpace.getY();
        double angle = Math.toRadians(rotationDegrees);

        room.pan(-centerX, -centerY);

        for (RoomSpace roomSpace: room.getAllSpaces()){
            //newx = p.x * cos(angle) - p.y * sin(angle)
            //newy = p.x * sin(angle) + p.y * cos(angle)
            double newX = roomSpace.getX() * Math.cos(angle) - roomSpace.getY() * Math.sin(angle);
            double newY = roomSpace.getX() * Math.sin(angle) + roomSpace.getY() * Math.cos(angle);
            roomSpace.setLocation((int) newX, (int) newY);
        }

        room.pan(centerX, centerY);
        //p.x = newx + c.x
        //p.y = newy + c.y
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<RoomSpace> getRoomSpaces(){
        return rooms.stream().map(room -> room.getAllSpaces()).flatMap(List::stream).collect(Collectors.toList());
    }
}
