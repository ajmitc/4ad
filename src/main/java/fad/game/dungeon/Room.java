package fad.game.dungeon;

import fad.game.chart.RoomContents;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private boolean corridor;
    private List<List<RoomSpace>> spaces = new ArrayList<>();
    private RoomContents roomContents;

    public boolean isCorridor() {
        return corridor;
    }

    public void setCorridor(boolean corridor) {
        this.corridor = corridor;
    }

    public RoomContents getRoomContents() {
        return roomContents;
    }

    public void setRoomContents(RoomContents roomContents) {
        this.roomContents = roomContents;
    }

    public List<List<RoomSpace>> getSpaces() {
        return spaces;
    }

    public List<RoomSpace> getAllSpaces() {
        return spaces.stream().flatMap(List<RoomSpace>::stream).collect(Collectors.toList());
    }
}
