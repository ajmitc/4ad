package fad.game.party;

/**
 *
 * @author aaron.mitchell
 */
public enum HeroTrait {
    ORC_ATTACK_BONUS("Orc Attack Bonus");

    private String name;
    HeroTrait(String n){
        this.name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
