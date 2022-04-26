package fad.game.equipment;

public class Weapon extends Equipment{
    public static final Weapon FISTS = new Weapon("Fists", EquipmentType.ONE_HAND_WEAPON, WeaponAttackType.CRUSHING);

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
