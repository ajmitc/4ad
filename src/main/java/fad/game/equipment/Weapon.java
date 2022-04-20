package fad.game.equipment;

public class Weapon extends Equipment{
    private WeaponAttackType attackType;

    public Weapon(String name, EquipmentType type, WeaponAttackType attackType){
        super(name, type);
        this.attackType = attackType;
    }

    public WeaponAttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(WeaponAttackType attackType) {
        this.attackType = attackType;
    }
}
