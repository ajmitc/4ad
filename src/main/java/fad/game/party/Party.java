package fad.game.party;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private final List<Hero> heroes = new ArrayList<>(4);

    public Party(){
        heroes.add(new Hero());
        heroes.add(new Hero());
        heroes.add(new Hero());
        heroes.add(new Hero());
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setType(Hero hero, HeroType type){
        hero.setType(type);

        switch(type){
            case WARRIOR:
                hero.setAttackType(AttackType.D6_PLUS_LEVEL);
                break;
            // TODO Set other Hero Type attributes here
        }
    }
}
