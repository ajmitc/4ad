package fad.game.party;

import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private final List<Hero> heroes = new ArrayList<>(4);

    public Party(){
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int size(){
        return heroes.size();
    }

    public Hero createHero(HeroType type){
        if (heroes.size() == 4)
            return null;
        Hero hero = null;

        switch(type){
            case WARRIOR: {
                hero = new Warrior();
                hero.setAttackType(AttackType.D6_PLUS_LEVEL);
                hero.setOneHandWeapon1(new Weapon("Sword", EquipmentType.ONE_HAND_WEAPON, WeaponAttackType.SLASHING));
                hero.setOneHandWeapon2(new Weapon("Shield", EquipmentType.ONE_HAND_WEAPON, WeaponAttackType.CRUSHING));
                hero.setArmor(new Equipment("Light Armor", EquipmentType.LIGHT_ARMOR));
                hero.setGold(Util.roll2d6());
                hero.setLifePoints(6 + hero.getLevel());
                break;
            }
            // TODO Set other Hero Type attributes here
        }

        heroes.add(hero);
        return hero;
    }
}
