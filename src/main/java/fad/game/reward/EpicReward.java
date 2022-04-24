package fad.game.reward;

/**
 * Each Epic Reward may only be obtained once per campaign.  If it is rolled again,
 * Re-roll until a different reward is selected.
 * 
 * @author aaron.mitchell
 */
public enum EpicReward {
    // Party is given this spell book that belonged to the legendary wizard, Skalitos.
    // Counts as one scroll of each of the six spells.
    // You may tear out the pages and distribute the six spells among the heros.
    // Book is destroyed if hero carrying book is killed by dragon breath.
    // If unused, the book may be sold for 650 GP at end of adventure.
    BOOK_OF_SKALITOS("The Book of Skalitos"),
    // Party is given the location of the treasure that belonged to a dwarf.
    // As soon as the party searches a room and generates at least one clue,
    // they may use that clue to find a hidden chest containing 500 GP.
    GOLD_OF_KERRAK_DAR("The Gold of Kerrak Dar"),
    // One of the party's weapons is enchanted and can now roll 2 dice for its Attack rolls,
    // choosing the best result.
    // The weapon can also hit monsters who are hit only by magic.  The enchantment lasts until the end of the adventure.
    ENCHANTED_WEAPON("Enchanted Weapon"),
    // One of the party's shields is enchanted and counts as protection even if the user is surprised by wandering
    // monsters or if the party is fleeing from a combat.  If the party has no shields, they will be given one.
    // The shield of warning is permanent, and will last throughout the campaign.
    // It can be sold for 200 GP.
    SHIELD_OF_WARNING("Shield of Warning"),
    // The party is given an arrow that will automatically inflect 3 wounds upon a monster.
    // Roll on the Boss table to determine which monster is affected by the arrow.
    // Can only be used by a Hero with a bow.  It strikes automatically against it's designated monster target.
    // Once used, the arrow breaks.  If unused, it may be sold for 3d6 x 15 GP.
    ARROW_OF_SLAYING("Arrow of Slaying"),
    // Party is given a holy symbol that may be used only by a cleric.
    // Cleric can make all healing rolls at +2 until he dies.
    // When Cleric dies, the holy symbol can be brought to the Cleric's church.  If the symbol
    // and the body of the Cleric are delivered to the church, an attempt to resurrect
    // that Cleric will be paid by the church.  
    // If unused, the symbol may be sold for 700 GP.
    HOLY_SYMBOL_OF_HEALING("Holy Symbol of Healing");

    private String name;
    EpicReward(String n){
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
