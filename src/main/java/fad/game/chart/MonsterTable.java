package fad.game.chart;

import fad.monster.Boss;
import fad.monster.MonsterTrait;
import fad.monster.Minion;
import fad.monster.MonsterType;
import fad.monster.Reaction;
import fad.util.Util;

/**
 *
 * @author aaron.mitchell
 */
public class MonsterTable {
    public static Minion getVermin(){
        int v = Util.roll();
        Minion vermin = null;
        switch(v){
            case 1:{
                vermin = new Minion(MonsterType.RATS, 1, Util.roll3d6());
                vermin.addTrait(MonsterTrait.INFECTIOUS);
                // No treasure
                // Reactions: 1-3 flee, 4-6 fight
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FLEE, Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
            }
            case 2:{
                vermin = new Minion(MonsterType.VAMPIRE_BATS, 1, Util.roll3d6());
                vermin.addTrait(MonsterTrait.DISTRACTING);
                // No treasure
                // Reactions: 1-3 flee, 4-6 fight
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FLEE, Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
            }
            case 3:{
                vermin = new Minion(MonsterType.GOBLIN_SWARMLINGS, 3, Util.roll2d6());
                // Treasure -1
                vermin.setTreasure(TreasureTable.getModified(-1));
                // TODO Morale -1
                // Dwarves attack them at +1
                vermin.addTrait(MonsterTrait.WEAK_AGAINST_DWARVES);
                // Reactions: 1 flee, 2-3 flee if outnumbered, 4 bribe (5GP x goblin), 5-6 fight
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FLEE_IF_OUTNUMBERED, Reaction.FLEE_IF_OUTNUMBERED, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT);
            }
            case 4: {
                vermin = new Minion(MonsterType.GIANT_CENTIPEDES, 3, Util.roll());
                // No Treasure
                // Any hero wounded by giant centipede must save versus level 2 poison or lose 1 additional life
                vermin.addTrait(MonsterTrait.POISONOUS);
                vermin.setPoisonLevel(2);
                // Reactions: 1 flee, 2-4 fight, 5-6 fight to the death
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
            }
            case 5:{
                vermin = new Minion(MonsterType.VAMPIRE_FROGS, 4, Util.roll());
                // Treasure -1
                vermin.setTreasure(TreasureTable.getModified(-1));
                // NOT undead
                // Reactions: 1 flee, 2-4 fight, 5-6 fight to the death
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
            }
            case 6: {
                vermin = new Minion(MonsterType.SKELETAL_RATS, 3, Util.roll2d6());
                // No Treasure
                // Clerics add +Level on attack rolls because undead
                vermin.addTrait(MonsterTrait.UNDEAD);
                // Crushing weapons have +1 on attack roll
                vermin.addTrait(MonsterTrait.WEAK_AGAINST_CRUSHING);
                // Cannot be attacked by bows or slings
                vermin.addTrait(MonsterTrait.IMMUNE_TO_RANGED_WEAPONS);
                // Reactions: 1-3 flee, 4-6 fight
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FLEE, Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
            }
        }
        return vermin;
    }

    public static Minion getMinion(){
        Minion minion = null;

        return minion;
    }

    public static Boss getWeirdMonster(){
        Boss monster = null;

        return monster;
    }

    public static Boss getBoss(){
        Boss monster = null;

        return monster;
    }
}
