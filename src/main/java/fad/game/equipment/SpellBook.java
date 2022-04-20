package fad.game.equipment;

import fad.game.spell.Spell;
import fad.game.spell.SpellType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aaron.mitchell
 */
public class SpellBook extends Equipment{
    private List<SpellType> availableSpellTypes = new ArrayList<>();

    public SpellBook(){
        super("Spell Book", EquipmentType.SPELL_BOOK);
    }

    public Spell ready(SpellType type){
        if (!availableSpellTypes.contains(type))
            return null;
        return new Spell(type);
    }

    public List<SpellType> getAvailableSpellTypes() {
        return availableSpellTypes;
    }
}
