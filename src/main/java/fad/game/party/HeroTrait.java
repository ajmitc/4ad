package fad.game.party;

/**
 *
 * @author aaron.mitchell
 */
public enum HeroTrait {
    ORC_ATTACK_BONUS("Orc Attack Bonus"),
    // Cast by wizard or elf on a hero using PROTECT spell
    // Grants +1 on defense rolls for a duration of battle
    PROTECTION("Protection");

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
