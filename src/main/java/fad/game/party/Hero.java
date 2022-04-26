package fad.game.party;

import fad.game.dungeon.Room;
import fad.game.equipment.Equipment;
import fad.game.equipment.EquipmentType;
import fad.game.equipment.Weapon;
import fad.game.spell.Spell;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    protected String name;
    protected HeroType type;
    protected AttackType attackType;
    protected AttackType spellCastType;
    protected AttackType solvePuzzleType;
    protected DefenseType defenseType;
    protected List<Equipment> inventory = new ArrayList<>();
    protected Equipment hand1;
    protected Equipment hand2;
    protected Equipment backSlingItem;
    protected Equipment armor;
    protected int gold;
    protected int level = 1;
    protected int lifePoints;
    //protected List<Clue> clues = new ArrayList<>();
    //protected List<Ability> abilities = new ArrayList<>();
    protected List<HeroTrait> traits = new ArrayList<>();

    protected List<Spell> readiedSpells = new ArrayList<>();
    protected int maxReadiedSpells = 0;

    // Clues may be "picked up" by other heroes if a hero carrying clues dies.
    // When the hero has 3+ clues, hero has discovered a major secret
    // Immediately make 1 XP roll, gaining a level if successful
    // Choose one secret to discover:
    // - Weakness of a monster: when you meet a boss of your choice, gain +2 
    //   attack against that boss.  Bonus lasts for whole combat.  All heroes in party enjoy bonus.
    // - Deal with a monster: When encountering a monster, declare you have a 
    //   deal with the creature.  Monster is peaceful.  Not available with vermin or final boss.
    // - Location of a secret treasure: in any empty room (not entrance), you 
    //   recognize it is location of secret treasure that can be revealed by speaking 
    //   the correct password.  A niche opens in a wall and you find 3d6 x 10 GP.
    // - Location of a magic item: Same as secret treasure, but you find a random magic item
    // - True name of a spiritual entity: You are in contact with angel or demon (player's 
    //   choice, but cannot be changed).  During game, may call an angel to heal a single
    //   hero to full health or rescue him out of a trapdoor.  May call a demon to
    //   inflict 4 lifepoints of damage to a single creature or automatically kill up to
    //   6 minions.  Once used, this is no longer available by that hero for remainder of campaign.
    // - New spell: Elf or Wizard may add a spell to repertoire.
    // - Secret to increase magical or spiritual power: Cleric, wizard, or elf, once per
    //   hero in campaign, can increase by 1 the number of times that you can use a single specific
    //   spell, or healing ability, during an adventure.
    // - Location of scroll: Any hero (not a barbarian) can take this.
    //   You find a scroll with a spell of your choice hidden in a niche in the dungeon.  If cast by a 
    //   non-spell-caster, the spell will be cast at level 1 even if the hero's level is higher.
    // - Recipe for a potion: You have to kill at least two boss monsters and spend 50 GP for
    //   material components of the potion.  After this, hero may purchase a potion of healing
    //   before every adventure, for 50 GP.
    // - Terrifying Secret: Whenever a monster (or group of minions) must make a morale roll in 
    //   hero's presence, you may utter the unspeakable secret, and the monster(s) will 
    //   automatically fail the morale roll.  This has no effect on monsters that don't make morale checks, or the final boss.
    // - Someone will pay big money for that: You know a nobleman who lost an heirloom or a jewel.  If you find a jewel, gem, or
    //   any item of jewelry with a GP value, and you manage to carry it out of the dungeon, sell it for 3x value.
    // - Your enemy is in the dungeon: A chaos lord has done something terrible to the hero and you know he's been plotting
    //   and scheming to hurt you.  When you meet a boss monster, you may change it to a chaos lord, and fight him with +1
    //   attack rolls.  The bonus lasts for the duration of the combat.
    // - Someone has been imprisoned: An important character (prince, noble, rich merchant, etc) is a 
    //   prisoner in the dungeon.  You may meet him in any room guarded by minions or a boss monster.
    //   If you manage to free him, and bring him out fo the dungeon alive, you will receive
    //   a random magic item and a random treasure, OR a doubling of your current GP, whatever is best for hero.
    //   The prisoner is chained to a wall.  Hero can break the chain during combat by winning an attack roll against level 4.
    //   Rogues and barbarians add their level when attempting to free character.
    //   Hero attempting to free the character may not attack the monsters that turn.
    // - You descend from a bloodline of drageon-slayers: Only barbarians and dwarves may take this.
    //   From now on, when that hero fights a dragon, add +1 to Defense and Attack rolls.
    // - Secret diet: You learn a secret diet to increase your stamina.  You may not share it with the party.
    //   As long as you spend 100 GP in food prior to each adventure, you will have +1 lifepoint
    //   until the end of the adventure.  Halflings can spend only 50 GP.
    protected int clues;

    protected Room currentRoom;

    protected int marchingOrder = 1;

    public Hero(){

    }

    /**
     * Get the Weapon that this hero is attacking with
     * @return 
     */
    public Weapon getAttackingWeapon(){
        if (hand1 != null && hand1 instanceof Weapon){
            return (Weapon) hand1;
        }
        if (hand2 != null && hand2 instanceof Weapon){
            return (Weapon) hand2;
        }
        return Weapon.FISTS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroType getType() {
        return type;
    }

    public void setType(HeroType type) {
        this.type = type;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public AttackType getSpellCastType() {
        return spellCastType;
    }

    public void setSpellCastType(AttackType spellCastType) {
        this.spellCastType = spellCastType;
    }

    public AttackType getSolvePuzzleType() {
        return solvePuzzleType;
    }

    public void setSolvePuzzleType(AttackType solvePuzzleType) {
        this.solvePuzzleType = solvePuzzleType;
    }

    public List<Equipment> getInventory() {
        return inventory;
    }

    public Equipment getHand1() {
        return hand1;
    }

    public void setHand1(Equipment hand1) {
        this.hand1 = hand1;
    }

    public Equipment getHand2() {
        return hand2;
    }

    public void setHand2(Equipment hand2) {
        this.hand2 = hand2;
    }

    public boolean isInHand(EquipmentType type){
        return (hand1 != null && hand1.getType() == type) || (hand2 != null && hand2.getType() == type);
    }

    public Equipment getBackSlingItem() {
        return backSlingItem;
    }

    public void setBackSlingItem(Equipment backSlingItem) {
        this.backSlingItem = backSlingItem;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void setArmor(Equipment armor) {
        this.armor = armor;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
        if (this.gold < 0)
            this.gold = 0;
    }

    public void adjGold(int amount) {
        setGold(gold + amount);
    }

    public DefenseType getDefenseType() {
        return defenseType;
    }

    public void setDefenseType(DefenseType defenseType) {
        this.defenseType = defenseType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void adjLevel(int amount) {
        this.level += amount;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
        if (this.lifePoints < 0)
            this.lifePoints = 0;
        if (this.lifePoints > getMaxLifePoints())
            this.lifePoints = getMaxLifePoints();
    }

    public void adjLifePoints(int amount) {
        setLifePoints(this.lifePoints + amount);
    }

    public abstract int getMaxLifePoints();

    public List<Spell> getReadiedSpells() {
        return readiedSpells;
    }

    public int getMaxReadiedSpells() {
        return maxReadiedSpells;
    }

    public void setMaxReadiedSpells(int maxReadiedSpells) {
        this.maxReadiedSpells = maxReadiedSpells;
    }

    public List<HeroTrait> getTraits() {
        return traits;
    }

    public void addTrait(HeroTrait trait) {
        this.traits.add(trait);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getClues() {
        return clues;
    }

    public void setClues(int clues) {
        this.clues = clues;
    }

    public int getMarchingOrder() {
        return marchingOrder;
    }

    public void setMarchingOrder(int marchingOrder) {
        this.marchingOrder = marchingOrder;
    }
}
