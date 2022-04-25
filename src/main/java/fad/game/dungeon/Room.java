package fad.game.dungeon;

import fad.game.chart.RoomContents;
import fad.game.monster.Monster;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private boolean visited = false;
    private boolean searched = false;
    private boolean corridor;
    private List<List<RoomSpace>> spaces = new ArrayList<>();
    private RoomContents roomContents;

    private Monster monster;

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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
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

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
}
