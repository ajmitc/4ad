package fad.monster;

/**
 *
 * @author aaron.mitchell
 */
public enum MonsterTrait {
    // Spells cast at -1 attack roll
    DISTRACTING("Distracting"),
    // Not affected by bows and slings
    IMMUNE_TO_RANGED_WEAPONS("Immune to ranged weapons"),
    // Any hero wounded has a 1 in 6 chance of losing an additional life due to infection
    INFECTIOUS("Infectious"),
    // Any hero woounded by this monster must save versus poison level or lose 1 life
    POISONOUS("Poisonous"),
    // This monster is considered undead
    UNDEAD("Undead"),
    // Crushing attacks get +1 on attack rolls
    WEAK_AGAINST_CRUSHING("Crushing weapons get +1 attack"),
    // Dwarves get +1 on attack rolls
    WEAK_AGAINST_DWARVES("Dwarves get +1 attack");

    private String name;
    MonsterTrait(String n){
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
