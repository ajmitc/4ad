package fad.game.chart;

import fad.util.Util;

public class SpecialFeatureTable {
    public static SpecialFeature get(){
        int v = Util.roll();
        switch (v){
            case 1:
                return SpecialFeature.FOUNTAIN;
            case 2:
                return SpecialFeature.BLESSED_TEMPLE;
            case 3:
                return SpecialFeature.ARMORY;
            case 4:
                return SpecialFeature.CURSED_ALTAR;
            case 5:
                return SpecialFeature.STATUE;
            case 6:
                return SpecialFeature.PUZZLE_ROOM;
        }
        return null;
    }
}
