package fad.game.party;

import fad.game.combat.CombatEncounter;
import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.EquipmentWeight;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.game.monster.MonsterType;
import fad.util.Util;

/**
 * Adds level to attack rolls, except when using ranged weapons (bows or slings)
 * +1 to defense rolls against trolls, ogres, and giants
 * +1 to attack rolls against goblins
 * When dwarf is in party, and you meet a monster, roll 1d6 and add dwarf's level
 *    If 6+, determine monster's treasure BEFORE deciding to attack the monster
 * If 2+ dwarves in party, party cannot bribe monsters
 * When the party finds treasure that can be split (ie. coins), you must always assign at least 1 coin to every
 *    dwarf in party, if possible.
 * When you sell a gem or jewelry and have a dwarf in party, +20% gold (round fractions down)
 * Allowed armor: shield, light armor, heavy armor
 * Allowed weapons: any
 * Starting equipment: light armor, shield, and hand weapon OR heavy armor and two-handed weapon
 * Starting wealth: 3d6
 * Life: 5 + level
 */
public class Dwarf extends Hero{

    public Dwarf(){
        super();
        name = "Gimli";
        type = HeroType.DWARF;
        attackType = AttackType.D6_PLUS_LEVEL;
        defenseType = DefenseType.D6;
        hand1 = new Weapon("Hand Axe", WeaponAttackType.SLASHING);
        hand2 = new Equipment(EquipmentType.SHIELD.getName(), EquipmentType.SHIELD);
        armor = new Equipment("Light Armor", EquipmentType.ARMOR, EquipmentWeight.LIGHT);
        setGold(Util.roll3d6());
        setLifePoints(getMaxLifePoints());
    }

    @Override
    public int getMaxLifePoints(){
        return 5 + level;
    }

    @Override
    public int getDefenseModifier(CombatEncounter encounter){
        int modifier = super.getDefenseModifier(encounter);
        if (encounter.getMonster().getType() == MonsterType.TROLLS || 
                encounter.getMonster().getType() == MonsterType.GIANT_CENTIPEDES ||
                encounter.getMonster().getType() == MonsterType.GIANT_SPIDER){
            modifier += 1;
        }
        return modifier;
    }
}
