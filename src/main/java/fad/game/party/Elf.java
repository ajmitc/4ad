package fad.game.party;

/**
 * Adds level to attack rolls except when using two-handed weapons
 * +1 to attack or spell roll when fighting any monster with "orc" in it's name
 * +Level to spell casting rolls and scrolls
 * Allowed Armor: shield, light armor, heavy armor
 * Allowed weapons: Any
 * Spells: May cast 1 spell per level per adventure, but only if wearing light armor and NO shield (unless strapped to back)
 *    Waste 1 attack to store/ready shield
 *    Spells must be prepared before adventure begins (like wizard)
 * Starting equipment: light armor, hand weapon, bow
 * Starting wealth: 2d6
 * Life: 4 + level
 */
public class Elf extends Hero{
    @Override
    public int getMaxLifePoints(){
        return 4 + level;
    }
}
