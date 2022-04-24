package fad.game.party;

import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.util.Util;

public class Warrior extends Hero{

    public Warrior(){
        setAttackType(AttackType.D6_PLUS_LEVEL);
        setHand1(new Weapon("Sword", EquipmentType.ONE_HAND_WEAPON, WeaponAttackType.SLASHING));
        setHand2(new Weapon("Shield", EquipmentType.ONE_HAND_WEAPON, WeaponAttackType.CRUSHING));
        setArmor(new Equipment("Light Armor", EquipmentType.LIGHT_ARMOR));
        setGold(Util.roll2d6());
        setLifePoints(getMaxLifePoints());
    }

    @Override
    public int getMaxLifePoints(){
        return 6 + level;
    }
}
