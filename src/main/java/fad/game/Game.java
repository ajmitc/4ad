package fad.game;

import fad.game.party.Party;

public class Game {
    private Party party;

    public Game(){
        party = new Party();
    }

    public Party getParty() {
        return party;
    }
}
