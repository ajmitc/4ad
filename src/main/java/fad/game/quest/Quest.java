package fad.game.quest;

/**
 *
 * @author aaron.mitchell
 */
public class Quest {
    private QuestType type;

    public Quest(QuestType type){
        this.type = type;
    }

    public QuestType getType() {
        return type;
    }
}
