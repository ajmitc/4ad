package fad.game.equipment;

import fad.game.combat.CombatEncounter;
import fad.game.party.AttackType;

public class Weapon extends Equipment{
    public static final Weapon FISTS = new Weapon("Fists", WeaponAttackType.CRUSHING, AttackType.D6_MINUS_TWO);

    private WeaponAttackType attackType;
    private AttackType attackModifier;

    public Weapon(String name, WeaponAttackType attackType){
        this(name, attackType, AttackType.D6);
    }

    public Weapon(String name, WeaponAttackType attackType, AttackType attackBonus){
        super(name, EquipmentType.WEAPON);
        this.attackType = attackType;
        this.attackModifier = attackBonus;
    }

    public WeaponAttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(WeaponAttackType attackType) {
        this.attackType = attackType;
    }

    public int getAttackModifier(CombatEncounter encounter) {
        int modifier = 0;
        // Two handed weapon
        if (getNumSlotUsage() > 1)
            modifier += 1;
        // light weapon
        if (getWeight() == EquipmentWeight.LIGHT)
            modifier -= 1;
        // Crushing weapons add +1 to skeletons
        if (getAttackType() == WeaponAttackType.CRUSHING && 
                (encounter.getMonster().getType().isSkeleton())){
            modifier += 1;
        }
        return modifier;
    }

    public void setAttackModifier(AttackType modifier) {
        this.attackModifier = modifier;
    }
}
