package fad.game.party;

import fad.game.combat.CombatEncounter;
import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.EquipmentWeight;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.game.monster.Minion;
import fad.game.monster.Monster;
import fad.util.Util;

/**
 * Adds level on rolls to disarm traps and defense rolls
 * Adds level to attack rolls only when attacking an outnumbered minion (more surviving party members than # minions)
 * Allowed armor: Light armor
 * Allowed weapons: light weapon, sling
 * Starting equipment: rope, lock picks, light armor, light hand weapon
 * Starting wealth: 3d6
 * Life: 3 + level.
 */
public class Rogue extends Hero{
    public Rogue(){
        super();
        setType(HeroType.ROGUE);
        setHand1(new Weapon("Dagger", WeaponAttackType.SLASHING));
        getHand1().setWeight(EquipmentWeight.LIGHT);
        //setHand2(new Weapon("Shield", EquipmentType.WEAPON, WeaponAttackType.CRUSHING));
        getInventory().add(new Equipment("Rope", EquipmentType.ROPE));
        getInventory().add(new Equipment("Lockpicks", EquipmentType.LOCK_PICKS));
        setArmor(new Equipment("Light Armor", EquipmentType.ARMOR, EquipmentWeight.LIGHT));
        setGold(Util.roll3d6());
        setLifePoints(getMaxLifePoints());
    }

    @Override
    public int getMaxLifePoints(){
        return 3 + level;
    }

    @Override
    public int getAttackModifier(CombatEncounter encounter){
        int modifier = super.getAttackModifier(encounter);
        if (encounter.getMonster().getType().isMinion() && ((Minion) encounter.getMonster()).getCount() < encounter.getHeroes().size())
            modifier += getLevel();
        return modifier;
    }

    @Override
    public int getDefenseModifier(CombatEncounter encounter){
        int modifier = super.getDefenseModifier(encounter);
        modifier += getLevel();
        return modifier;
    }
}
