package fad.game.monster;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aaron.mitchell
 */
public class Minion extends Monster{
    private int count = 1;

    public Minion(MonsterType type, int level, int count){
        super(type, level);
        this.count = count;
    }

    public Minion(final Minion other){
        super(other);
    }

    /**
     * Return count number of minions, all with the same attributes as this monster
     * @return 
     */
    public List<Minion> expand(){
        List<Minion> minions = new ArrayList<>();
        for (int i = 0; i < count; ++i){
            minions.add(new Minion(this));
        }
        return minions;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
