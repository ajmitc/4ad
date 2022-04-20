package fad.game.spell;

/**
 *
 * @author aaron.mitchell
 */
public class Spell {
    private SpellType type;

    public Spell(SpellType type){
        this.type = type;
    }

    public SpellType getType() {
        return type;
    }
}
