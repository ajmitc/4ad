package fad.game.party;

import fad.game.combat.CombatEncounter;
import fad.game.monster.MonsterTrait;

/**
 * 
 */
public class Cleric extends Hero{

    public Cleric(){
        super();
        name = "Cedric";
        type = HeroType.CLERIC;
        attackType = AttackType.D6_PLUS_HALF_LEVEL;
        /*
        spellCastType = AttackType.D6_PLUS_LEVEL;
        solvePuzzleType = AttackType.D6_PLUS_LEVEL;
        defenseType = DefenseType.D6;
        hand1 = new Weapon("Knife", EquipmentType.ONE_HAND_WEAPON, WeaponAttackType.SLASHING);
        hand1.setWeight(EquipmentWeight.LIGHT);
        inventory.add(new Equipment("Spell Book", EquipmentType.SPELL_BOOK));
        inventory.add(new Equipment("Writing Implements", EquipmentType.WRITING_IMPLEMENTS));
        gold = Util.roll4d6();
        level = 1;
        lifePoints = getMaxLifePoints();
        */
    }

    @Override
    public int getMaxLifePoints(){
        return 2 + level;
    }

    @Override
    public int getAttackModifier(CombatEncounter encounter){
        int modifier = super.getAttackModifier(encounter);
        if (encounter.getMonster().hasTrait(MonsterTrait.UNDEAD)){
            // Do it this way to properly handle rounding errors
            modifier -= (getLevel() / 2);
            modifier += getLevel();
        }
        return modifier;
    }

    @Override
    public int getMaxReadiedSpells(){
        return 2 + level;
    }
}
