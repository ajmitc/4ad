package fad.game.monster;

import fad.game.reward.Treasure;
import fad.util.Util;
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

    // Number of times this monster can be hit before dying
    protected int hitpoints = 1;

    // Number of attacks this monster can make
    protected int numAttacks = 1;

    // Number of points of damage inflicted on hero by each attack
    protected int numDamagePerAttack = 1;

    protected Set<MonsterTrait> traits = new HashSet<>();

    // Treasure dropped by this monster. If null, no treasure.
    protected List<Treasure> treasure = new ArrayList<>();

    // Roll 1d6 and return Reaction at that index
    protected List<Reaction> reactionChoices = new ArrayList<>();
    protected Reaction reaction;

    protected int poisonLevel = 0;
    protected int fireBreathLevel = 0;

    // Number of GP to demand for a bribe
    // If number is -1, then roll d6 GP per monster
    // If number is -2, roll 6d6 GP
    // If number is -3, All gold of the party, with minimum of 100 GP or one magic item
    protected int bribeAmountPerMonster = 0;


    public Monster(MonsterType type){
        this(type, 1);
    }

    public Monster(MonsterType type, int level){
        this.type = type;
    }

    public Monster(final Monster other){
        this.type = other.type;
        this.level = other.level;
        this.hitpoints = other.hitpoints;
        this.numAttacks = other.numAttacks;
        this.numDamagePerAttack = other.numDamagePerAttack;
        this.traits.addAll(other.traits);
        this.treasure.addAll(other.treasure);
        this.reactionChoices.addAll(other.reactionChoices);
        this.reaction = other.reaction;
        this.poisonLevel = other.poisonLevel;
        this.fireBreathLevel = other.fireBreathLevel;
        this.bribeAmountPerMonster = other.bribeAmountPerMonster;
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

    public boolean hasTrait(MonsterTrait trait){
        return traits.contains(trait);
    }

    public List<Treasure> getTreasure() {
        return treasure;
    }

    public void addTreasure(Treasure treasure) {
        this.treasure.add(treasure);
    }

    public List<Reaction> getReactionChoices() {
        return reactionChoices;
    }

    public void setReactionChoices(Reaction ... reactions){
        reactionChoices.addAll(Arrays.asList(reactions));
    }

    public Reaction rollForReaction(){
        return reactionChoices.get(Util.roll() - 1);
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

    public int getBribeAmountPerMonster() {
        return bribeAmountPerMonster;
    }

    public void setBribeAmountPerMonster(int bribeAmountPerMonster) {
        this.bribeAmountPerMonster = bribeAmountPerMonster;
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public int getNumDamagePerAttack() {
        return numDamagePerAttack;
    }

    public void setNumDamagePerAttack(int numDamagePerAttack) {
        this.numDamagePerAttack = numDamagePerAttack;
    }

    public int getFireBreathLevel() {
        return fireBreathLevel;
    }

    public void setFireBreathLevel(int fireBreathLevel) {
        this.fireBreathLevel = fireBreathLevel;
    }

}
