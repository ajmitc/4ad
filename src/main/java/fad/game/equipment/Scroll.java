package fad.game.equipment;

import fad.game.spell.Spell;

/**
 * Scrolls cannot be used by Barbarians
 * @author aaron.mitchell
 */
public class Scroll extends Equipment{
    private final Spell spell;

    public Scroll(Spell spell){
        super("Scroll of " + spell.getType(), EquipmentType.SCROLL);
        this.spell = spell;
        this.setNumUses(1);
    }

    public Spell getSpell() {
        return spell;
    }
}
