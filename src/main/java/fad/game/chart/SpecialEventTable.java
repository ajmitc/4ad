package fad.game.chart;

import fad.util.Util;

public class SpecialEventTable {
    public static SpecialEvent get(){
        int v = Util.roll();
        switch (v){
            case 1:
                return SpecialEvent.GHOST;
            case 2:
                return SpecialEvent.WANDERING_MONSTER;
            case 3:
                return SpecialEvent.LADY_IN_WHITE;
            case 4:
                return SpecialEvent.TRAP;
            case 5:
                return SpecialEvent.WANDERING_HEALER;
            case 6:
                return SpecialEvent.WANDERING_ALCHEMIST;
        }
        return null;
    }
}
