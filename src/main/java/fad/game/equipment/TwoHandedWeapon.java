package fad.game.equipment;

import fad.game.party.AttackType;

/**
 *
 * @author aaron.mitchell
 */
public class TwoHandedWeapon extends Weapon{
    public TwoHandedWeapon(String name, WeaponAttackType weaponAttackType){
        super(name, weaponAttackType, AttackType.D6_PLUS_ONE);
        this.setNumSlotUsage(2);
    }
}
