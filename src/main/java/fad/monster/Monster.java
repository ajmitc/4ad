package fad.monster;

import fad.game.chart.Treasure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author aaron.mitchell
 */
public abstract class Monster {
    protected MonsterType type;

    // ie. If monster is level 3, you need to roll a 3+ to hit it
    // You must roll 4+ to defend against it
    protected int level = 1;

    protected int hitpoints = 1;

    protected Set<MonsterTrait> traits = new HashSet<>();

    protected Treasure treasure;

    // Roll 1d6 and return Reaction at that index
    protected List<Reaction> reactionChoices = new ArrayList<>();
    protected Reaction reaction;

    protected int poisonLevel = 0;


    public Monster(MonsterType type){
        this(type, 1);
    }

    public Monster(MonsterType type, int level){
        this.type = type;
    }

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public Set<MonsterTrait> getTraits() {
        return traits;
    }

    public void addTrait(MonsterTrait trait){
        traits.add(trait);
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public List<Reaction> getReactionChoices() {
        return reactionChoices;
    }

    public void setReactionChoices(Reaction ... reactions){
        reactionChoices.addAll(Arrays.asList(reactions));
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public int getPoisonLevel() {
        return poisonLevel;
    }

    public void setPoisonLevel(int poisonLevel) {
        this.poisonLevel = poisonLevel;
    }
}
