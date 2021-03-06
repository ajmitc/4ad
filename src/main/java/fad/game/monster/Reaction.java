package fad.game.monster;

/**
 *
 * @author aaron.mitchell
 */
public enum Reaction {
    ASK_BRIBE("Ask for bribe"),
    FIGHT("Fight"),
    // Do not make a morale test
    FIGHT_TO_DEATH("Fight to the death"),
    // Monster disappears from dungeon.  It drops it's treasure.
    FLEE("Flee"),
    FLEE_IF_OUTNUMBERED("Flee"),
    // If party has wizard or magic item allowing to cast spell, duel against monster
    // Accept:
    //   Roll d6 + wizard level.  If >= monster level, wins.
    //   Win: monster leaves and wizard gets treasure
    //   Lose: wizard loses a level (may go to level 0 - cannot perform spells), monster attacks
    // Refuse: monster attacks
    MAGIC_CHALLENGE("Magic Challenge"),
    // Heal one wound per hero
    OFFER_FOOD_REST("Offer food and rest"),
    // Monster will not attack, but also won't help heroes.  Does not drop treasure.
    PEACEFUL("Peaceful"),
    // Monster offers puzzle/riddle which has level.  If heroes roll the level or better on d6,
    // the puzzle is solved and monster lets heroes go.  If failed, monster attacks heroes first.
    // Heroes get only one chance to solve puzzle.
    PUZZLE("Puzzle"),
    // Monster asks heroes to perform quest.
    // Accept: Roll on Quest table, complete quest, then return to same room and roll on Epic Rewards table
    // Refuse: Monster leaves
    QUEST("Quest"),
    // All heros can attack at +2 on their first attack
    SLEEPING("Sleeping"),
    SPECIAL("Special");
    
    private String name;
    Reaction(String n){
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
