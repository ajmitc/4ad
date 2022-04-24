package fad.game.chart;

import fad.game.quest.Quest;
import fad.game.quest.QuestType;
import fad.util.Util;

/**
 *
 * @author aaron.mitchell
 */
public class QuestTable {
    public static Quest get(){
        int v = Util.roll();
        switch(v){
            case 1:
                return new Quest(QuestType.BRING_ME_HIS_HEAD);
            case 2:
                return new Quest(QuestType.BRING_ME_GOLD);
            case 3:
                return new Quest(QuestType.I_WANT_HIM_ALIVE);
            case 4:
                return new Quest(QuestType.BRING_ME_THAT);
            case 5:
                return new Quest(QuestType.LET_PEACE_BE_YOUR_WAY);
            case 6:
                return new Quest(QuestType.SLAY_ALL_THE_MONSTERS);
        }
        return null;
    }
}
