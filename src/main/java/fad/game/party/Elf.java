package fad.game.party;

import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.EquipmentWeight;
import fad.game.equipment.TwoHandedWeapon;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.util.Util;

/**
 * Adds level to attack rolls except when using two-handed weapons
 * +1 to attack or spell roll when fighting any monster with "orc" in it's name
 * +Level to spell casting rolls and scrolls
 * Allowed Armor: shield, light armor, heavy armor
 * Allowed weapons: Any
 * Spells: May cast 1 spell per level per adventure, but only if wearing light armor and NO shield (unless strapped to back)
 *    Waste 1 attack to store/ready shield
 *    Spells must be prepared before adventure begins (like wizard)
 * Starting equipment: light armor, hand weapon, bow
 * Starting wealth: 2d6
 * Life: 4 + level
 */
public class Elf extends Hero{
    public Elf(){
        super();
        setName("Legolas");
        setType(HeroType.ELF);
        setAttackType(AttackType.D6_PLUS_LEVEL);
        setSpellCastType(AttackType.D6_PLUS_LEVEL);
        setDefenseType(DefenseType.D6);
        setBackSlingItem(new Weapon("Sword", WeaponAttackType.SLASHING));
        setHand1(new TwoHandedWeapon("Bow", WeaponAttackType.RANGED));
        setArmor(new Equipment("Light Armor", EquipmentType.ARMOR, EquipmentWeight.LIGHT));
        setGold(Util.roll2d6());
        setLifePoints(getMaxLifePoints());

        addTrait(HeroTrait.ORC_ATTACK_BONUS);
    }
    @Override
    public int getMaxLifePoints(){
        return 4 + level;
    }

    @Override
    public int getMaxReadiedSpells(){
        if ((armor == null || armor.getWeight() == EquipmentWeight.LIGHT) && !isInHand(EquipmentType.SHIELD))
            return level;
        return 0;
    }
}
