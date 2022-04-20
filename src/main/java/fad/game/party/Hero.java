package fad.game.party;

import fad.game.equipment.Equipment;
import fad.game.equipment.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    protected String name;
    protected HeroType type;
    protected AttackType attackType;
    protected DefenseType defenseType;
    protected List<Equipment> inventory = new ArrayList<>();
    protected Weapon oneHandWeapon1;
    protected Weapon oneHandWeapon2;
    protected Weapon twoHandedWeapon;
    protected Weapon backSlingWeapon;
    protected Equipment armor;
    protected int gold;
    protected int level = 1;
    protected int lifePoints;
    //protected List<Clue> clues = new ArrayList<>();
    //protected List<Ability> abilities = new ArrayList<>();

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

    public List<Equipment> getInventory() {
        return inventory;
    }

    public Equipment getOneHandWeapon1() {
        return oneHandWeapon1;
    }

    public void setOneHandWeapon1(Weapon oneHandWeapon1) {
        this.oneHandWeapon1 = oneHandWeapon1;
    }

    public Equipment getOneHandWeapon2() {
        return oneHandWeapon2;
    }

    public void setOneHandWeapon2(Weapon oneHandWeapon2) {
        this.oneHandWeapon2 = oneHandWeapon2;
    }

    public Equipment getTwoHandedWeapon() {
        return twoHandedWeapon;
    }

    public void setTwoHandedWeapon(Weapon twoHandedWeapon) {
        this.twoHandedWeapon = twoHandedWeapon;
    }

    public Equipment getBackSlingWeapon() {
        return backSlingWeapon;
    }

    public void setBackSlingWeapon(Weapon backSlingWeapon) {
        this.backSlingWeapon = backSlingWeapon;
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
    }

    public void adjLifePoints(int amount) {
        setLifePoints(this.lifePoints + amount);
    }
}
