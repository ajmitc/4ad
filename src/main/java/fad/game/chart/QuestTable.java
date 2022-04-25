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
        Quest quest = null;
        switch(v){
            case 1:
                quest = new Quest(QuestType.BRING_ME_HIS_HEAD);
                quest.setBoss(MonsterTable.getBoss());
                break;
            case 2:
                quest = new Quest(QuestType.BRING_ME_GOLD);
                quest.setTreasureValue(Util.roll() * 50);
                // TODO If party treasure value > quest treasure value, double quest treasure value
                break;
            case 3:
                quest = new Quest(QuestType.I_WANT_HIM_ALIVE);
                quest.setBoss(MonsterTable.getBoss());
                break;
            case 4:
                quest = new Quest(QuestType.BRING_ME_THAT);
                quest.setTreasure(TreasureTable.getMagicTreasure());
                break;
            case 5:
                quest = new Quest(QuestType.LET_PEACE_BE_YOUR_WAY);
                quest.setRemainingNumNonViolentEncounters(3);
                break;
            case 6:
                quest = new Quest(QuestType.SLAY_ALL_THE_MONSTERS);
                break;
        }
        return quest;
    }
}
