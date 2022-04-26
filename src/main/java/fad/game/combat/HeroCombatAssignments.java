package fad.game.combat;

import fad.game.party.Hero;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to track what Heroes will do during a combat turn
 * @author aaron.mitchell
 */
public class HeroCombatAssignments {
    private Map<Hero, HeroCombatAction> actions = new HashMap<>();

    public Map<Hero, HeroCombatAction> getActions() {
        return actions;
    }
}
