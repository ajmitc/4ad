package fad.game.party;

import fad.game.combat.CombatEncounter;
import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.EquipmentWeight;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.game.monster.Minion;
import fad.game.monster.Monster;
import fad.game.monster.MonsterType;
import fad.util.Util;

/**
 */
public class Halfling extends Hero{
    public Halfling(){
        super();
        setType(HeroType.HALFLING);
        /*
        setHand1(new Weapon("Dagger", WeaponAttackType.SLASHING));
        //setHand2(new Weapon("Shield", EquipmentType.WEAPON, WeaponAttackType.CRUSHING));
        getInventory().add(new Equipment("Rope", EquipmentType.ROPE));
        getInventory().add(new Equipment("Lockpicks", EquipmentType.LOCK_PICKS));
        setArmor(new Equipment("Light Armor", EquipmentType.ARMOR, EquipmentWeight.LIGHT));
        setGold(Util.roll3d6());
        */
        setLifePoints(getMaxLifePoints());
    }

    @Override
    public int getMaxLifePoints(){
        return 3 + level;
    }

    @Override
    public int getDefenseModifier(CombatEncounter encounter){
        int modifier = super.getDefenseModifier(encounter);
        // Halfling defending against troll, giant, or ogre: +L
        if (encounter.getMonster().getType() == MonsterType.TROLLS ||
                encounter.getMonster().getType() == MonsterType.GIANT_CENTIPEDES ||
                encounter.getMonster().getType() == MonsterType.GIANT_SPIDER ||
                encounter.getMonster().getType() == MonsterType.OGRE){
            modifier += getLevel();
        }
        return modifier;
    }
}
