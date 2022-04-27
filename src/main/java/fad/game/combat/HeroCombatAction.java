package fad.game.combat;

/**
 *
 * @author aaron.mitchell
 */
public enum HeroCombatAction {
    ATTACK("Melee Attack"),
    CAST_SPELL("Cast Spell"),
    // Switch weapon strapped to back (ie. take out/store a bow)
    SWITCH_WEAPON("Switch Weapon");

    private String name;
    HeroCombatAction(String n){
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
