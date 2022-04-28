package fad.game.party;

import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.EquipmentWeight;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.util.Util;

public class Warrior extends Hero{

    public Warrior(){
        super();
        setType(HeroType.WARRIOR);
        setAttackType(AttackType.D6_PLUS_LEVEL);
        setHand1(new Weapon("Sword", WeaponAttackType.SLASHING));
        setHand2(new Equipment("Shield", EquipmentType.SHIELD));
        setArmor(new Equipment("Light Armor", EquipmentType.ARMOR, EquipmentWeight.LIGHT));
        setGold(Util.roll2d6());
        setLifePoints(getMaxLifePoints());
    }

    @Override
    public int getMaxLifePoints(){
        return 6 + level;
    }
}
