package fad.game.quest;

import fad.game.equipment.EquipmentType;
import fad.game.monster.Boss;
import fad.game.reward.Treasure;

/**
 *
 * @author aaron.mitchell
 */
public class Quest {
    private QuestType type;
    // Target of BRING ME HIS HEAD and I WANT HIM ALIVE
    private Boss boss;

    // Total amount of treasure value that must be brought back
    private int treasureValue;

    // Target of BRING_ME_THAT!
    private Treasure treasure;

    // Remaining number of non-violent encounters before Let Peace Be Your Way
    // When this quest is received, set this value to 3 and decrement when a non-violent encounter is resolved
    private int remainingNumNonViolentEncounters;

    public Quest(QuestType type){
        this.type = type;
    }

    public QuestType getType() {
        return type;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public int getTreasureValue() {
        return treasureValue;
    }

    public void setTreasureValue(int treasureValue) {
        this.treasureValue = treasureValue;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public int getRemainingNumNonViolentEncounters() {
        return remainingNumNonViolentEncounters;
    }

    public void setRemainingNumNonViolentEncounters(int remainingNumNonViolentEncounters) {
        this.remainingNumNonViolentEncounters = remainingNumNonViolentEncounters;
    }

    public void adjRemainingNumNonViolentEncounters(int amount) {
        this.remainingNumNonViolentEncounters += amount;
    }
}
