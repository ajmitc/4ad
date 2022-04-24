package fad.game.quest;

/**
 * Whenever a quest is completed, roll on the Epic Rewards table
 * 
 * @author aaron.mitchell
 */
public enum QuestType {
    // Kill a boss monster
    // Roll on MonsterTable to determine who.
    // The next time the party meets a boss in a room, instead of rolling it up, yo umay use the boss from the quest.
    // Killing the boss and bringing it's head to the creature's room completes the quest.
    BRING_ME_HIS_HEAD("Bring me his head!"),
    // Bring d6 x 50 worth of treasure to this room.
    // If the party already has that amount of treasure available, the amount required is doubled
    BRING_ME_GOLD("Bring me gold!"),
    // Same as BRING_ME_HIS_HEAD, but the party must subdue to the Boss, tie him up with a rope, 
    // and take him to the creature's room to complete the quest.
    // To subdue the monster, you must either use the Sleep spell or fight with -1 on all Attack rolls (striking
    // with the flat of the blade or trying to knock out the boss instead of killing him)
    I_WANT_HIM_ALIVE("I want him alive!"),
    // Roll on the magic item table to determine what the object is.
    // Every time the party kills a boss, there is a 1 in 6 chance that he will have that object in addition to his treasure, if any.
    // To complete the quest, the party must bring the object in the room where the quest started.
    BRING_ME_THAT("Bring me that!"),
    // To complete the quest, the party must complete at least three encounters in the adventure in a non-violent
    // way.  This includes reactions such as bribing, getting help from monsters, performing another quest (not this one),
    // or defeating a monster with the sleep spell and then tying him up with a rope.
    LET_PEACE_BE_YOUR_WAY("Let peace be your way!"),
    // To complete the quest, all the dungeon rooms must be laid out and all the occupants slain, with the exception
    // of the creature who gave the quest.  As soon as these conditions are met, the party can claim their reward.
    SLAY_ALL_THE_MONSTERS("Slay all the monsters!");

    private String name;
    QuestType(String n){
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
