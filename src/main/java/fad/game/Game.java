package fad.game;

import fad.game.dungeon.Dungeon;
import fad.game.party.Party;

public class Game {
    private Party party;
    private Dungeon dungeon;

    public Game(){
        party = new Party();
        dungeon = new Dungeon();
    }

    public Party getParty() {
        return party;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

}
