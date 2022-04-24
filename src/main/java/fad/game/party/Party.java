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
                break;
            }
            case ELF: {
                hero = new Elf();
                break;
            }
            case DWARF: {
                hero = new Dwarf();
                break;
            }
            case WIZARD: {
                hero = new Wizard();
                break;
            }
        }

        heroes.add(hero);
        return hero;
    }
}
