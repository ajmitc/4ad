package fad.game.monster;

/**
 *
 * @author aaron.mitchell
 */
public enum MonsterTrait {
    // Must test morale each time one or more monsters are killed by a spell
    AFRAID_OF_MAGIC("Afraid of Magic"),
    // 1 in 6 chance of gaining surprise, thus acting before the party.  If they do, roll on their reaction table.
    AMBUSHER("Ambusher"),
    // First Defense roll against this monster is at -1
    BULL_RUSH("Bull Rush"),
    // Defense rolls against this monster do not enjoy bous from heavy armor
    CANCEL_HEAVY_ARMOR_BONUS("Cancel Heavy Armor Bonus"),
    // Heroes may not roll for XP after this encounter
    CANCEL_XP_ROLL("Cancel XP Roll"),
    // Spells cast at -1 attack roll
    DISTRACTING("Distracting"),
    // If a Dwarf is present in the party, this monster will always fight to the death
    DWARF_HATRED("Hates Dwarves"),
    // Any hero taking damage from this monster must roll 4+ or lose 1 level
    ENERGY_DRAIN("Energy Drain"),
    // Heros must roll 4+ or be at -1 on all defense rolls until the monster is slain
    EVIL_EYE("Evil Eye"),
    // May breath fire instead of normal attack
    FIRE_BREATHER("Fire Breather"),
    // At beginning of battle, each hero must save versus a level 4 gaze attack or be turned to stone.
    // Petrified heros are out of game until a Blessing spell is cast on them.
    GAZE_ATTACK("Gaze Attack"),
    // before combat, all heros must roll 6+ or lose 2 hitpoints (Clerics add 1/2 level to this roll)
    HELLFIRE_BLAST("Hellfire Blast"),
    // Not affected by bows and slings
    IMMUNE_TO_RANGED_WEAPONS("Immune to ranged weapons"),
    // Any hero wounded has a 1 in 6 chance of losing an additional life due to infection
    INFECTIOUS("Infectious"),
    // Cannot fight something you cannot see
    INVISIBLE("Invisible"),
    // Special Iron Eater attack
    IRON_EATER_ATTACK("Hero takes no damage, but loses armor, shield, main weapon, or 3d6 GP"),
    // When this monster dies, roll 1d6.  On 5-6, monster drops a clue
    MAY_DROP_CLUE("May Drop Clue"),
    // May not use Fool's Gold against this monster
    NOT_FOOLED_BY_FOOLS_GOLD("Not fooled by Fool's Gold"),
    // Any hero woounded by this monster must save versus poison level or lose 1 life
    POISONOUS("Poisonous"),
    // Regenerate (unless killed by a spell, or unless a hero uses one attack to chop an already killed troll to bits)
    // Roll a die for every killed troll on it's next turn.  On 5-6, troll will come back to life and continue to fight.
    REGENERATE("Regenerate"),
    // Arrows have -1 on attack roll
    STRONG_AGAINST_ARROWS("Strong against arrows"),
    // Steals d6+3 objects from party
    // Heroes must surrender objects from any hero in this order:
    //   Magic items, Scrolls, Potions, Weapons, Gems, Coins (in bundles of 10GP each)
    // If all equipment are stolen, they will leave a thank you message that counts as a clue.
    THIEVES("Thieves"),
    // This monster is considered undead
    UNDEAD("Undead"),
    // Halflings may not use Luck in an encounter with this monster
    UNLUCKY_HALFLINGS("Unlucky Halflings"),
    // Does not test morale
    UNWAVERING("Unwavering"),
    // Any hero killed by this monster becomes a Mummy and must be fought by the party
    VICTIM_BECOMES_MUMMY("Victims become mummies"),
    // Crushing attacks get +1 on attack rolls
    WEAK_AGAINST_CRUSHING("Crushing weapons get +1 attack"),
    // Elves get +1 attack and spell casts
    WEAK_AGAINST_ELVES("Elves get +1 attack & spells"),
    // Dwarves get +1 on attack rolls
    WEAK_AGAINST_DWARVES("Dwarves get +1 attack"),
    // Fireballs inflict +2 attack roll
    WEAK_AGAINST_FIREBALLS("Weak against fireballs"),
    // If number of monsters drops below 50%, the remaining monsters will test morale at -1
    WEAK_RESOLVE("Weak Resolve"),
    // Spider web prevents heroes from withdrawing from battle. Heroes must cast a Fireball spell to burn webs to undo this trait
    WEB_PREVENTS_WITHDRAW("Webbing prevents withdraw");

    private String name;
    MonsterTrait(String n){
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
