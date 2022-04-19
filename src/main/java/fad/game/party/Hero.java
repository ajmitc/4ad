package fad.game.party;

import fad.game.equipment.Equipment;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private HeroType type;
    private AttackType attackType;
    private List<Equipment> inventory = new ArrayList<>();
    private Equipment oneHandWeapon1;
    private Equipment oneHandWeapon2;
    private Equipment twoHandedWeapon;
    private Equipment backSlingWeapon;
    private Equipment armor;

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

    public void setOneHandWeapon1(Equipment oneHandWeapon1) {
        this.oneHandWeapon1 = oneHandWeapon1;
    }

    public Equipment getOneHandWeapon2() {
        return oneHandWeapon2;
    }

    public void setOneHandWeapon2(Equipment oneHandWeapon2) {
        this.oneHandWeapon2 = oneHandWeapon2;
    }

    public Equipment getTwoHandedWeapon() {
        return twoHandedWeapon;
    }

    public void setTwoHandedWeapon(Equipment twoHandedWeapon) {
        this.twoHandedWeapon = twoHandedWeapon;
    }

    public Equipment getBackSlingWeapon() {
        return backSlingWeapon;
    }

    public void setBackSlingWeapon(Equipment backSlingWeapon) {
        this.backSlingWeapon = backSlingWeapon;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void setArmor(Equipment armor) {
        this.armor = armor;
    }
}
