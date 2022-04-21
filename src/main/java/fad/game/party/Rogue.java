package fad.game.party;

/**
 * Adds level on rolls to disarm traps and defense rolls
 * Adds level to attack rolls only when attacking an outnumbered minion (more surviving party members than # minions)
 * Allowed armor: Light armor
 * Allowed weapons: light weapon, sling
 * Starting equipment: rope, lock picks, light armor, light hand weapon
 * Starting wealth: 3d6
 * Life: 3 + level.
 */
public class Rogue extends Hero{
    @Override
    public int getMaxLifePoints(){
        return 3 + level;
    }
}
