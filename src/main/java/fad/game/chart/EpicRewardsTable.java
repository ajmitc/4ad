package fad.game.chart;

import fad.game.reward.EpicReward;
import fad.util.Util;

/**
 *
 * @author aaron.mitchell
 */
public class EpicRewardsTable {
    public static EpicReward get(){
        int v = Util.roll();
        switch(v){
            case 1:
                return EpicReward.BOOK_OF_SKALITOS;
            case 2:
                return EpicReward.GOLD_OF_KERRAK_DAR;
            case 3:
                return EpicReward.ENCHANTED_WEAPON;
            case 4:
                return EpicReward.SHIELD_OF_WARNING;
            case 5:
                return EpicReward.ARROW_OF_SLAYING;
            case 6:
                return EpicReward.HOLY_SYMBOL_OF_HEALING;
        }
        return null;
    }
}
