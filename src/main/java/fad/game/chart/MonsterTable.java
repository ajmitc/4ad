package fad.game.chart;

import fad.game.reward.Treasure;
import fad.game.monster.Boss;
import fad.game.monster.MonsterTrait;
import fad.game.monster.Minion;
import fad.game.monster.MonsterType;
import fad.game.monster.Reaction;
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
                break;
            }
            case 2:{
                vermin = new Minion(MonsterType.VAMPIRE_BATS, 1, Util.roll3d6());
                vermin.addTrait(MonsterTrait.DISTRACTING);
                // No treasure
                // Reactions: 1-3 flee, 4-6 fight
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FLEE, Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                break;
            }
            case 3:{
                vermin = new Minion(MonsterType.GOBLIN_SWARMLINGS, 3, Util.roll2d6());
                // Treasure -1
                vermin.addTreasure(TreasureTable.getModified(-1));
                // TODO Morale -1
                // Dwarves attack them at +1
                vermin.addTrait(MonsterTrait.WEAK_AGAINST_DWARVES);
                // Reactions: 1 flee, 2-3 flee if outnumbered, 4 bribe (5GP x goblin), 5-6 fight
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FLEE_IF_OUTNUMBERED, Reaction.FLEE_IF_OUTNUMBERED, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT);
                break;
            }
            case 4: {
                vermin = new Minion(MonsterType.GIANT_CENTIPEDES, 3, Util.roll());
                // No Treasure
                // Any hero wounded by giant centipede must save versus level 2 poison or lose 1 additional life
                vermin.addTrait(MonsterTrait.POISONOUS);
                vermin.setPoisonLevel(2);
                // Reactions: 1 flee, 2-4 fight, 5-6 fight to the death
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
                break;
            }
            case 5:{
                vermin = new Minion(MonsterType.VAMPIRE_FROGS, 4, Util.roll());
                // Treasure -1
                vermin.addTreasure(TreasureTable.getModified(-1));
                // NOT undead
                // Reactions: 1 flee, 2-4 fight, 5-6 fight to the death
                vermin.setReactionChoices(Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
                break;
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
                break;
            }
        }
        return vermin;
    }

    public static Minion getMinion(){
        Minion minion = null;
        int v = Util.roll();
        switch(v){
            case 1:{
                if (Util.nextInt(100) < 50){
                    minion = new Minion(MonsterType.SKELETONS, 3, Util.roll() + 2);
                }
                else {
                    minion = new Minion(MonsterType.ZOMBIES, 3, Util.roll());
                }
                minion.addTrait(MonsterTrait.UNDEAD);
                minion.addTrait(MonsterTrait.WEAK_AGAINST_CRUSHING);
                minion.addTrait(MonsterTrait.STRONG_AGAINST_ARROWS);
                minion.addTrait(MonsterTrait.UNWAVERING);
                // No treasure
                // Reactions: Always fight to the death
                minion.setReactionChoices(Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
                break;
            }
            case 2:{
                minion = new Minion(MonsterType.GOBLINS, 3, Util.roll() + 3);
                minion.addTrait(MonsterTrait.AMBUSHER);
                minion.addTrait(MonsterTrait.WEAK_AGAINST_DWARVES);
                // treasure -1
                minion.addTreasure(TreasureTable.getModified(-1));
                minion.setReactionChoices(Reaction.FLEE_IF_OUTNUMBERED, Reaction.ASK_BRIBE, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                minion.setBribeAmountPerMonster(5);
                break;
            }
            case 3:{
                minion = new Minion(MonsterType.HOBGOBLINS, 4, Util.roll());
                // treasure +1
                minion.addTreasure(TreasureTable.getModified(1));
                minion.setReactionChoices(Reaction.FLEE_IF_OUTNUMBERED, Reaction.ASK_BRIBE, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH);
                minion.setBribeAmountPerMonster(10);
                break;
            }
            case 4:{
                minion = new Minion(MonsterType.ORCS, 4, Util.roll() + 1);
                minion.addTrait(MonsterTrait.AFRAID_OF_MAGIC);
                minion.addTrait(MonsterTrait.WEAK_AGAINST_ELVES);
                minion.addTrait(MonsterTrait.WEAK_RESOLVE);
                // treasure (never any magic item - if magic item is rolled, treat it as d6xd6 GP instead)
                Treasure treasure = TreasureTable.get();
                if (treasure.isMagic()){
                    treasure = Treasure.D6_X_D6;
                }
                minion.addTreasure(treasure);
                minion.setReactionChoices(Reaction.ASK_BRIBE, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH);
                minion.setBribeAmountPerMonster(10);
                break;
            }
            case 5:{
                minion = new Minion(MonsterType.TROLLS, 5, Util.roll() + 1);
                minion.addTrait(MonsterTrait.REGENERATE);
                minion.addTrait(MonsterTrait.DWARF_HATRED);
                minion.addTreasure(TreasureTable.get());
                minion.setReactionChoices(Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
                break;
            }
            case 6:{
                minion = new Minion(MonsterType.FUNGI_FOLK, 3, Util.roll2d6());
                minion.addTrait(MonsterTrait.POISONOUS);
                minion.setPoisonLevel(3);
                minion.addTreasure(TreasureTable.get());
                minion.setReactionChoices(Reaction.ASK_BRIBE, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                minion.setBribeAmountPerMonster(-1);
                break;
            }
        }

        return minion;
    }

    public static Boss getWeirdMonster(){
        Boss monster = null;
        int v = Util.roll();
        switch(v){
            case 1:{
                monster = new Boss(MonsterType.MINOTAUR, 5);
                monster.setHitpoints(4);
                monster.setNumAttacks(2);
                monster.addTrait(MonsterTrait.BULL_RUSH);
                monster.addTrait(MonsterTrait.UNLUCKY_HALFLINGS);
                monster.addTreasure(TreasureTable.get());
                monster.setReactionChoices(Reaction.ASK_BRIBE, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
                monster.setBribeAmountPerMonster(60);
                break;
            }
            case 2:{
                monster = new Boss(MonsterType.IRON_EATER, 3);
                monster.setHitpoints(4);
                monster.setNumAttacks(3);
                monster.addTrait(MonsterTrait.CANCEL_HEAVY_ARMOR_BONUS);
                monster.addTrait(MonsterTrait.IRON_EATER_ATTACK);
                monster.addTrait(MonsterTrait.NOT_FOOLED_BY_FOOLS_GOLD);
                monster.setReactionChoices(Reaction.FLEE, Reaction.ASK_BRIBE, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                monster.setBribeAmountPerMonster(-1);
                break;
            }
            case 3:{
                monster = new Boss(MonsterType.CHIMERA, 5);
                monster.setHitpoints(6);
                monster.setNumAttacks(3);
                monster.addTreasure(TreasureTable.get());
                monster.addTrait(MonsterTrait.FIRE_BREATHER);
                monster.setFireBreathLevel(4);
                monster.setReactionChoices(Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                monster.setBribeAmountPerMonster(50);
                break;
            }
            case 4:{
                monster = new Boss(MonsterType.CATOBLEPAS, 4);
                monster.setHitpoints(4);
                monster.addTreasure(TreasureTable.getModified(1));
                monster.addTrait(MonsterTrait.GAZE_ATTACK);
                monster.setReactionChoices(Reaction.FLEE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                break;
            }
            case 5:{
                monster = new Boss(MonsterType.GIANT_SPIDER, 5);
                monster.setHitpoints(3);
                monster.setNumAttacks(2);
                monster.addTreasure(TreasureTable.get());
                monster.addTreasure(TreasureTable.get());
                monster.addTrait(MonsterTrait.POISONOUS);
                monster.setPoisonLevel(3);
                monster.addTrait(MonsterTrait.WEB_PREVENTS_WITHDRAW);
                monster.setReactionChoices(Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                break;
            }
            case 6:{
                monster = new Boss(MonsterType.INVISIBLE_GREMLINS, 1);
                monster.addTrait(MonsterTrait.INVISIBLE);
                monster.addTrait(MonsterTrait.THIEVES);
                monster.addTrait(MonsterTrait.CANCEL_XP_ROLL);
                monster.addTrait(MonsterTrait.UNWAVERING);
                monster.setReactionChoices(Reaction.FLEE, Reaction.FLEE, Reaction.FLEE, Reaction.FLEE, Reaction.FLEE, Reaction.FLEE);
                break;
            }
        }

        return monster;
    }

    public static Boss getBoss(){
        Boss monster = null;
        int v = Util.roll();
        switch(v){
            case 1:{
                monster = new Boss(MonsterType.MUMMY, 5);
                monster.setHitpoints(4);
                monster.setNumAttacks(2);
                monster.addTrait(MonsterTrait.UNDEAD);
                monster.addTrait(MonsterTrait.VICTIM_BECOMES_MUMMY);
                monster.addTrait(MonsterTrait.WEAK_AGAINST_FIREBALLS);
                monster.addTrait(MonsterTrait.UNWAVERING);
                monster.addTreasure(TreasureTable.getModified(2));
                monster.setReactionChoices(Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT);
                break;
            }
            case 2:{
                monster = new Boss(MonsterType.ORC_BRUTE, 5);
                monster.setHitpoints(5);
                monster.setNumAttacks(2);
                Treasure treasure = TreasureTable.getModified(1);
                if (treasure.isMagic()){
                    treasure = Treasure.TWO_D6_X_D6;
                }
                monster.addTreasure(treasure);
                monster.setReactionChoices(Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH);
                monster.setBribeAmountPerMonster(50);
                break;
            }
            case 3:{
                monster = new Boss(MonsterType.OGRE, 5);
                monster.setHitpoints(6);
                monster.setNumDamagePerAttack(2);
                monster.addTreasure(TreasureTable.get());
                monster.setReactionChoices(Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
                monster.setBribeAmountPerMonster(30);
                break;
            }
            case 4:{
                monster = new Boss(MonsterType.MEDUSA, 4);
                monster.setHitpoints(4);
                monster.addTreasure(TreasureTable.getModified(1));
                monster.addTrait(MonsterTrait.GAZE_ATTACK);
                monster.setReactionChoices(Reaction.ASK_BRIBE, Reaction.QUEST, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH);
                monster.setBribeAmountPerMonster(-2);
                break;
            }
            case 5:{
                monster = new Boss(MonsterType.CHAOS_LORD, 6);
                monster.setHitpoints(4);
                monster.setNumAttacks(3);
                monster.addTreasure(TreasureTable.getModified(1));
                monster.addTreasure(TreasureTable.getModified(1));
                // Special powers
                int d = Util.roll();
                if (d == 4){
                    monster.addTrait(MonsterTrait.EVIL_EYE);
                }
                else if (d == 5){
                    monster.addTrait(MonsterTrait.ENERGY_DRAIN);
                }
                else if (d == 6){
                    monster.addTrait(MonsterTrait.HELLFIRE_BLAST);
                }
                monster.addTrait(MonsterTrait.MAY_DROP_CLUE);
                monster.setReactionChoices(Reaction.FLEE_IF_OUTNUMBERED, Reaction.FIGHT, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH, Reaction.FIGHT_TO_DEATH);
                break;
            }
            case 6:{
                monster = getSmallDragon();
                break;
            }
        }
        return monster;
    }

    /**
     * On each turn of the dragon, roll d6 to determine what it does:
     * 1-2: Dragon breathes fire, inflicting 1HP on all heroes that fail to save versus level 6 dragon breath (each character adds 1/2 level, rounded down)
     * 3-6: Dragon bites 2 random heroes.
     * 
     * Dragons are never met as random monsters
     * @return 
     */
    public static Boss getSmallDragon(){
        Boss monster = new Boss(MonsterType.SMALL_DRAGON, 6);
        monster.setHitpoints(5);
        monster.setNumAttacks(2);
        monster.addTreasure(TreasureTable.getModified(1));
        monster.addTreasure(TreasureTable.getModified(1));
        monster.addTreasure(TreasureTable.getModified(1));
        monster.setReactionChoices(Reaction.SLEEPING, Reaction.ASK_BRIBE, Reaction.ASK_BRIBE, Reaction.FIGHT, Reaction.FIGHT, Reaction.QUEST);
        monster.setBribeAmountPerMonster(-3);
        return monster;
    }
}
