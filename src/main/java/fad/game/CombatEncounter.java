package fad.game;

import fad.game.dungeon.Room;
import fad.game.monster.Monster;
import fad.game.party.Hero;
import java.util.List;

/**
 *
 * @author aaron.mitchell
 */
public class CombatEncounter {
    // Room where the combat is taking place
    private Room room;

    // Heroes taking part in the combat (should be list of heroes in the above room)
    private List<Hero> heroes;

    // Monster(s) the heroes are fighting
    private Monster monster;

    // If true, it's the hero's turn to attack
    // If false, it's the monster's turn to attack
    private boolean heroesTurn = true;

    // Number of turns taken during this combat
    // A turn is either a hero or monster turn
    // Number of rounds is turns / 2
    private int turns = 0;

    private boolean resolved = false;

    public CombatEncounter(Room room, List<Hero> heroes, Monster monster){
        this.room = room;
        this.heroes = heroes;
        this.monster = monster;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public boolean isHeroesTurn() {
        return heroesTurn;
    }

    public void setHeroesTurn(boolean heroesTurn) {
        this.heroesTurn = heroesTurn;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
