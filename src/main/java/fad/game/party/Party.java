package fad.game.party;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Hero> heroes = new ArrayList<>(4);

    public Party(){
        heroes.add(new Hero());
        heroes.add(new Hero());
        heroes.add(new Hero());
        heroes.add(new Hero());
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

}
