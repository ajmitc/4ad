package fad.game.dungeon;

import fad.game.chart.RoomContents;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private boolean corridor;
    private List<List<RoomSpace>> spaces = new ArrayList<>();
    private RoomContents roomContents;

    public void assignLocationCoordinates(int startingX, int startingY){
        for (int r = 0; r < spaces.size(); ++r){
            for (int c = 0; c < spaces.get(r).size(); ++c){
                spaces.get(r).get(c).setLocation(startingX + c, startingY + r);
            }
        }
    }

    public void pan(int dx, int dy){
        for (int r = 0; r < spaces.size(); ++r){
            for (int c = 0; c < spaces.get(r).size(); ++c){
                int x = spaces.get(r).get(c).getX();
                int y = spaces.get(r).get(c).getY();
                spaces.get(r).get(c).setLocation(x + dx, y + dy);
            }
        }
    }

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
