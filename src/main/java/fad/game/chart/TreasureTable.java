package fad.game.chart;

import fad.game.reward.Treasure;
import fad.game.reward.TreasureComplication;
import fad.util.Util;

/**
 *
 * @author aaron.mitchell
 */
public class TreasureTable {
    public static Treasure get(){
        return get(Util.roll());
    }

    public static Treasure getModified(int modifier){
        return get(Util.roll() + modifier);
    }

    public static Treasure get(int v){
        if (v <= 0) return Treasure.NOTHING;
        switch(v){
            case 1: return Treasure.D6;
            case 2: return Treasure.TWO_D6;
            case 3: return Treasure.SCROLL;
            case 4: return Treasure.GEM;
            case 5: return Treasure.JEWELRY;
            default:
                return Treasure.MAGIC_TREASURE;
        }
    }

    public static Treasure getMagicTreasure(){
        int v = Util.roll();
        switch(v){
            case 1: return Treasure.WAND_OF_SLEEP;
            case 2: return Treasure.RING_OF_TELEPORTATION;
            case 3: return Treasure.FOOLS_GOLD;
            case 4: return Treasure.MAGIC_WEAPON;
            case 5: return Treasure.POTION_OF_HEALING;
            case 6: return Treasure.FIREBALL_STAFF;
        }
        return null;
    }

    public static TreasureComplication getHiddenTreasureComplication(){
        switch(Util.roll()){
            case 1:
            case 2:
                return TreasureComplication.WANDERING_MONSTER;
            case 3:
            case 4:
            case 5:
                return TreasureComplication.TRAP;
            case 6:
                return TreasureComplication.GHOST;
        }
        return null;
    }
}
