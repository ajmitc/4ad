package fad.game;

import fad.game.dungeon.Dungeon;
import fad.game.party.Party;

public class Game {
    private Party party;
    private Dungeon dungeon;

    private Phase phase;
    private PhaseStep phaseStep;

    public Game(){
        party = new Party();
        dungeon = new Dungeon();

        phase = Phase.SETUP;
        phaseStep = PhaseStep.START_PHASE;
    }

    public Party getParty() {
        return party;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public PhaseStep getPhaseStep() {
        return phaseStep;
    }

    public void setPhaseStep(PhaseStep phaseStep) {
        this.phaseStep = phaseStep;
    }
}
