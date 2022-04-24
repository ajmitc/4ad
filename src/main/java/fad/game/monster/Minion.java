package fad.game.monster;

/**
 *
 * @author aaron.mitchell
 */
public class Minion extends Monster{
    private int count;

    public Minion(MonsterType type, int level, int count){
        super(type, level);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
