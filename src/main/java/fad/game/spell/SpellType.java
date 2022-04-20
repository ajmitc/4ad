package fad.game.spell;

/**
 *
 * @author aaron.mitchell
 */
public enum SpellType {
    // Removes a curse or condition from a Hero
    BLESSING("Blessing"),
    // Works like an attack. Wizard adds level to roll.
    // Does not affect dragons (but it does affect zombie dragons)
    // Against minions, slays a number of creatures equal to wizard's die roll minus the level of the minions (minimum of one)
    FIREBALL("Fireball"),
    // Works like an attack. Wizard adds level to roll.
    // Does not affect dragons (but it does affect zombie dragons)
    // Against minions, kills just one, if it hits
    // Against a boss, inflicts 2 damage, if it hits
    LIGHTNING_BOLT("Lightning Bolt"),
    // Works like an attack. Wizard adds level to roll.
    // Does not affect undead, dragons, and certain other monsters
    // Defeats one boss or d6+L minions, if it hits
    // Monsters put to sleep count as slain
    SLEEP("Sleep"),
    // Wizard disappears from current location and reappears in first room of the game.
    // This spell may be cast in lieu of making a Defense roll, or it may be cast normally in the party's turn
    // Works automatically
    ESCAPE("Escape"),
    // Gives +1 to single Hero's defense roll for duration of battle
    PROTECT("Protect");

    private String name;
    SpellType(String n){
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
