package fad.game.party;

import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.EquipmentWeight;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.util.Util;

/**
 * Adds level only when attacking with spells (including scrolls) or on rolls to solve puzzles/riddles
 * Allowed armor: None
 * Allowed weapons: Light weapon, sling
 * Spells: begin game with 2 spells + 1 per level
 *   Wizard must prepare spells before adventure starts.  May prepare multiple copies of same spell or any combo of 6 available spells
 *   Wizard may find additional spells in adventures and add them to repertoire of spells he can prepare.
 *   Spells acquired when leveling up may be used immediately.
 * Starting equipment: light hand weapon, spell book, writing implements
 * Starting wealth: 4d6
 * Life: 2 + level
 */
public class Wizard extends Hero{

    public Wizard(){
        super();
        name = "Gandolf";
        type = HeroType.WIZARD;
        attackType = AttackType.D6;
        spellCastType = AttackType.D6_PLUS_LEVEL;
        solvePuzzleType = AttackType.D6_PLUS_LEVEL;
        defenseType = DefenseType.D6;
        hand1 = new Weapon("Knife", WeaponAttackType.SLASHING);
        hand1.setWeight(EquipmentWeight.LIGHT);
        inventory.add(new Equipment("Spell Book", EquipmentType.SPELL_BOOK));
        inventory.add(new Equipment("Writing Implements", EquipmentType.WRITING_IMPLEMENTS));
        gold = Util.roll4d6();
        level = 1;
        lifePoints = getMaxLifePoints();
    }

    @Override
    public int getMaxLifePoints(){
        return 2 + level;
    }

    public int getMaxReadiedSpells(){
        return 2 + level;
    }
}
