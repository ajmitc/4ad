package fad.game.party;

import fad.game.dungeon.Room;
import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.Weapon;
import fad.game.equipment.WeaponAttackType;
import fad.util.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Party {
    private final List<Hero> heroes = new ArrayList<>(4);

    public Party(){
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public Hero find(HeroType type){
        for (Hero hero: heroes){
            if (hero.getType() == type)
                return hero;
        }
        return null;
    }

    public List<Hero> getHeroesInRoom(Room room){
        return heroes.stream()
                .filter(hero -> hero.getCurrentRoom() == room)
                .sorted(new Comparator<Hero>(){
                    @Override
                    public int compare(Hero h1, Hero h2){
                        return h1.getMarchingOrder() < h2.getMarchingOrder()? -1: h1.getMarchingOrder() > h2.getMarchingOrder()? 1: 0;
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Check if any hero in the part can cast a spell
     * @return 
     */
    public boolean canCastSpell(){
        boolean magical = false;
        for (Hero hero: heroes){
            if (hero.getType() == HeroType.WIZARD || hero.getType() == HeroType.ELF){
                magical = true;
            }
            // TODO Check for magical item
        }
        return magical;
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
