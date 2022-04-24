package fad.game.party;

import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.spell.Spell;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    protected String name;
    protected HeroType type;
    protected AttackType attackType;
    protected AttackType spellCastType;
    protected AttackType solvePuzzleType;
    protected DefenseType defenseType;
    protected List<Equipment> inventory = new ArrayList<>();
    protected Equipment hand1;
    protected Equipment hand2;
    protected Equipment backSlingItem;
    protected Equipment armor;
    protected int gold;
    protected int level = 1;
    protected int lifePoints;
    //protected List<Clue> clues = new ArrayList<>();
    //protected List<Ability> abilities = new ArrayList<>();
    protected List<HeroTrait> traits = new ArrayList<>();

    protected List<Spell> readiedSpells = new ArrayList<>();
    protected int maxReadiedSpells = 0;

    public Hero(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroType getType() {
        return type;
    }

    public void setType(HeroType type) {
        this.type = type;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public AttackType getSpellCastType() {
        return spellCastType;
    }

    public void setSpellCastType(AttackType spellCastType) {
        this.spellCastType = spellCastType;
    }

    public AttackType getSolvePuzzleType() {
        return solvePuzzleType;
    }

    public void setSolvePuzzleType(AttackType solvePuzzleType) {
        this.solvePuzzleType = solvePuzzleType;
    }

    public List<Equipment> getInventory() {
        return inventory;
    }

    public Equipment getHand1() {
        return hand1;
    }

    public void setHand1(Equipment hand1) {
        this.hand1 = hand1;
    }

    public Equipment getHand2() {
        return hand2;
    }

    public void setHand2(Equipment hand2) {
        this.hand2 = hand2;
    }

    public boolean isInHand(EquipmentType type){
        return (hand1 != null && hand1.getType() == type) || (hand2 != null && hand2.getType() == type);
    }

    public Equipment getBackSlingItem() {
        return backSlingItem;
    }

    public void setBackSlingItem(Equipment backSlingItem) {
        this.backSlingItem = backSlingItem;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void setArmor(Equipment armor) {
        this.armor = armor;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
        if (this.gold < 0)
            this.gold = 0;
    }

    public void adjGold(int amount) {
        setGold(gold + amount);
    }

    public DefenseType getDefenseType() {
        return defenseType;
    }

    public void setDefenseType(DefenseType defenseType) {
        this.defenseType = defenseType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
        if (this.lifePoints < 0)
            this.lifePoints = 0;
        if (this.lifePoints > getMaxLifePoints())
            this.lifePoints = getMaxLifePoints();
    }

    public void adjLifePoints(int amount) {
        setLifePoints(this.lifePoints + amount);
    }

    public abstract int getMaxLifePoints();

    public List<Spell> getReadiedSpells() {
        return readiedSpells;
    }

    public int getMaxReadiedSpells() {
        return maxReadiedSpells;
    }

    public void setMaxReadiedSpells(int maxReadiedSpells) {
        this.maxReadiedSpells = maxReadiedSpells;
    }

    public List<HeroTrait> getTraits() {
        return traits;
    }

    public void addTrait(HeroTrait trait) {
        this.traits.add(trait);
    }
}
