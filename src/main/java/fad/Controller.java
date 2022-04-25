package fad;

import fad.game.CombatEncounter;
import fad.game.Game;
import fad.game.Phase;
import fad.game.PhaseStep;
import fad.game.chart.MonsterTable;
import fad.game.chart.RoomContents;
import fad.game.chart.RoomContentsTable;
import fad.game.chart.SpecialEvent;
import fad.game.chart.SpecialEventTable;
import fad.game.chart.SpecialFeature;
import fad.game.chart.SpecialFeatureTable;
import fad.game.reward.Treasure;
import fad.game.chart.TreasureTable;
import fad.game.dungeon.Room;
import fad.game.dungeon.RoomFactory;
import fad.game.dungeon.RoomSpace;
import fad.game.equipment.Scroll;
import fad.game.equipment.SpellBook;
import fad.game.equipment.TreasureEquipment;
import fad.game.party.Hero;
import fad.game.party.HeroType;
import fad.game.spell.Spell;
import fad.game.spell.SpellType;
import fad.game.monster.Boss;
import fad.game.monster.Minion;
import fad.game.monster.Monster;
import fad.game.monster.MonsterTrait;
import fad.game.monster.MonsterType;
import fad.game.monster.Reaction;
import fad.util.Util;
import fad.view.View;
import fad.view.ViewUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Controller {
    private Model model;
    private View view;

    // PLAY_SELECT_ROOMS_TO_MOVE phasestep
    // When a hero moves through a door or hallway, place that Hero in this Map
    // along with the RoomSpace representing the door or hallway they pass through.
    private Map<Hero, RoomSpace> moveThresholds = new HashMap<>();

    // List of rooms where combat will occur
    private List<Room> encounterRooms = new ArrayList<>();
    private CombatEncounter combatEncounter;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;

        view.getMainMenuPanel().getBtnExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        view.getMainMenuPanel().getBtnNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Game game = new Game();
                model.setGame(game);
                view.showGame();
                run();
            }
        });
    }

    public void run(){
        if (model.getGame() == null)
            return;
        while (model.getGame().getPhase() != Phase.GAMEOVER){
            switch(model.getGame().getPhase()){
                case SETUP:{
                    switch(model.getGame().getPhaseStep()){
                        case START_PHASE:{
                            // TODO Let player select heroes
                            model.getGame().getParty().createHero(HeroType.WARRIOR);
                            model.getGame().getParty().createHero(HeroType.ELF);
                            model.getGame().getParty().createHero(HeroType.DWARF);
                            model.getGame().getParty().createHero(HeroType.WIZARD);

                            // TODO Let Dwarf choose starting equipment
                            // TODO Let Elf and Wizard ready spells

                            createDungeon();
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case END_PHASE:{
                            model.getGame().setPhase(Phase.PLAY);
                            break;
                        }
                    }
                    break;
                }
                case PLAY:{
                    switch(model.getGame().getPhaseStep()){
                        case START_PHASE:{
                            // TODO Let player select adjacent room to move to
                            // TODO If re-visiting a room, roll 1d6.  On a 1, a wandering monster attacks the party
                            //      in reverse-marching order.  Monster attacks first.  After 1 turn, all party members
                            //      can fight monster.
                            //      Wandering Monsters do NOT appear in rooms with a bribed monster.  Instead roll on 
                            //      the reaction table for the bribed monster.  If another bribe is rolled, and player
                            //      refuses to pay, the monster will attack.  On any other reaction result, the monster
                            //      does nothing.
                            //      Party may attack the monster and recover any bribes paid earlier (as well as any non-bribe treasure
                            //      held by the monster)
                            //
                            //      If the party splits up, roll wandering monsters for each room with at least 1 hero

                            // TODO Objective of game is to slay the dungeon's final boss and exit the dungeon.
                            //      Each time party encounters a Boss Monster, roll 1d6 and add 1 for every boss & weird monster already encountered.
                            //      On 6+, this boss monster is the final boss.
                            //      When you enter the last room in the dungeon, that room will automatically have the final boss monster.
                            //      Final Boss will have +1 lifepoint, +1 number of attacks, and automatically fights to the death.  
                            //      The Boss's GP treasure is 3x (or increased by 100GP, whichever is better).  If it has a magic item, it has 2 magic items instead.
                            
                            model.getGame().setPhaseStep(PhaseStep.PLAY_SELECT_ROOMS_TO_MOVE);
                            break;
                        }
                        case PLAY_SELECT_ROOMS_TO_MOVE:{
                            // TODO If party is all together, let user select door or hallway to pass 
                            //      through, open dialog to let user select which heroes enter next room.
                            //      By default, all heroes in that room are selected.
                            // TODO Any hero NOT selected to move will stay in current room
                            return;
                        }
                        case PLAY_MOVE_HEROES:{
                            Set<Room> destinationRoomSet = new HashSet();
                            for (Hero hero: moveThresholds.keySet()){
                                Room room = hero.getCurrentRoom();
                                RoomSpace threshold = moveThresholds.get(hero);
                                Room nextRoom = getRoomAcrossThreshold(room, threshold);
                                hero.setCurrentRoom(nextRoom);
                                destinationRoomSet.add(nextRoom);
                            }
                            encounterRooms.clear();
                            for (Room room: destinationRoomSet){
                                handleRoomContents(room);
                            }
                            model.getGame().setPhaseStep(PhaseStep.PLAY_START_ENCOUNTER);
                            break;
                        }
                        case PLAY_START_ENCOUNTER:{
                            if (encounterRooms.isEmpty()){
                                model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                                break;
                            }
                            Room room = encounterRooms.remove(0);
                            handleEncounter(room);
                            break;
                        }
                        case PLAY_START_COMBAT:{
                            if (combatEncounter == null){
                                model.getGame().setPhaseStep(PhaseStep.PLAY_END_COMBAT);
                                break;
                            }
                            model.getGame().setPhaseStep(PhaseStep.PLAY_COMBAT_ROUND);
                            break;
                        }
                        case PLAY_COMBAT_ROUND:{
                            if (combatEncounter == null || combatEncounter.isResolved())
                                model.getGame().setPhaseStep(PhaseStep.PLAY_END_COMBAT);
                            else
                                doCombatRound(combatEncounter);
                            break;
                        }
                        case PLAY_END_COMBAT:{
                            combatEncounter = null;
                            model.getGame().setPhaseStep(PhaseStep.PLAY_START_ENCOUNTER);
                            break;
                        }
                        case END_PHASE:{
                            model.getGame().setPhase(Phase.PLAY);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    public void createDungeon(){
        Room entrance = RoomFactory.createEntranceRoom();
        model.getGame().getDungeon().getRooms().add(entrance);

        // Add rooms off all entrance connection points
        model.getGame().getDungeon().addConnectingRooms(entrance);
    }

    /**
     * Get the room on the other side of a threshold (door or hallway).
     * If the room already exists, return it.  Otherwise, create it.
     */
    public Room getRoomAcrossThreshold(Room fromRoom, RoomSpace threshold){
        if (threshold.getConnectingRoom() != null){
            // If no bribed monster, roll for wandering monster.  Otherwise, check if bribed monster asks for another bribe or does nothing.
            Room room = threshold.getConnectingRoom(); 
            if (room.isVisited()){
                if (room.getMonster() != null && room.getMonster().getReaction() == Reaction.ASK_BRIBE){
                    Reaction reaction = room.getMonster().rollForReaction();
                    if (reaction != Reaction.ASK_BRIBE){
                        reaction = Reaction.PEACEFUL;
                    }
                    room.getMonster().setReaction(reaction);
                }
                else {
                    if (Util.roll() == 1){
                        // Wandering Monster!
                        spawnWanderingMonster(room);
                    }
                }
            }
            return room;
        }
        // Roll d66 for room
        Room room = RoomFactory.createRoom();
        // Add room to dungeon
        model.getGame().getDungeon().getRooms().add(room);
        // TODO fit room to threshold
        threshold.setConnectingRoom(room);
        // Get Room Contents
        RoomContents roomContents = RoomContentsTable.getRoomContents();
        room.setRoomContents(roomContents);
        return room;
    }

    public void handleRoomContents(Room room){
        room.setVisited(true);
        switch(room.getRoomContents()){
            case TREASURE:{
                // Roll on Treasure Table
                Treasure treasure = TreasureTable.get();
                System.out.println("Found treasure: " + treasure);
                // Handle treasure
                resolveTreasure(treasure, null);
                break;
            }
            case TREASURE_WITH_TRAP:{
                // TODO Roll on Traps Table
                // If survive, Roll on Treasure Table
                Treasure treasure = TreasureTable.get();
                System.out.println("Found treasure: " + treasure);
                // Handle treasure
                resolveTreasure(treasure, null);
                break;
            }
            case SPECIAL_EVENT_IF_ROOM:{
                // If room, Roll on Special Event table
                if (!room.isCorridor()){
                    SpecialEvent event = SpecialEventTable.get();
                    // TODO Handle event
                }
                // Otherwise, Empty
                askEmptyRoom(room);
                break;
            }
            case SPECIAL_FEATURE:{
                // Empty, but Roll on Special Feature table
                SpecialFeature feature = SpecialFeatureTable.get();
                // TODO Handle special feature
                break;
            }
            case VERMIN:{
                // Roll on Vermin table
                Minion vermin = MonsterTable.getVermin();
                System.out.println("You find " + vermin.getType());
                room.setMonster(vermin);
                encounterRooms.add(room);
                // Ask if heros want to attack or wait to see what the monster does
                break;
            }
            case MINION:{
                // Roll on minions table
                Minion minion = MonsterTable.getMinion();
                room.setMonster(minion);
                encounterRooms.add(room);
                break;
            }
            case MINION_IF_ROOM:{
                // if room, roll on minions table.  Then, if win, Roll on Treasure table
                if (!room.isCorridor()){
                    Minion minion = MonsterTable.getMinion();
                    room.setMonster(minion);
                    encounterRooms.add(room);
                }
                // if corridor, Empty
                else {
                    System.out.println("Corridor is empty");
                    askEmptyRoom(room);
                }
                break;
            }
            case EMPTY:
                System.out.println("Room is empty");
                askEmptyRoom(room);
                break;
            case WIERD_MONSTER_IF_ROOM:{
                // if room, Roll on Weird Monster table.  If win, Roll for leveling up and roll on treasure table
                if (!room.isCorridor()){
                    Boss monster = MonsterTable.getWeirdMonster();
                    room.setMonster(monster);
                    encounterRooms.add(room);
                }
                // if corridor, empty
                else {
                    System.out.println("Corridor is empty");
                }
                break;
            }
            case BOSS:{
                // Roll on Boss table.  If win, roll for leveling up and roll on treasure table
                Boss monster = MonsterTable.getBoss();
                room.setMonster(monster);
                encounterRooms.add(room);
                // TODO if room, maybe final Boss
                break;
            }
            case SMALL_DRAGONS_LAIR:{
                // if corridor, empty
                if (room.isCorridor()){
                    System.out.println("Corridor is empty");
                    askEmptyRoom(room);
                }
                // if room, this is a Small Dragon's Lair (see boss table). 
                // TODO If win, roll for leveling up and roll on treasure table
                else {
                    Boss monster = MonsterTable.getSmallDragon();
                    room.setMonster(monster);
                    encounterRooms.add(room);
                }
                break;
            }
        }
    }

    private void resolveTreasure(Treasure treasure, Hero hero){
        switch(treasure){
            case D6:{
                int v = Util.roll();
                if (hero != null)
                    hero.adjGold(v);
                else
                    splitGoldAmongParty(v);
                break;
            }
            case TWO_D6:{
                int v = Util.roll2d6();
                if (hero != null)
                    hero.adjGold(v);
                else
                    splitGoldAmongParty(v);
                break;
            }
            case D6_X_D6: {
                int v = Util.roll() * Util.roll();
                if (hero != null)
                    hero.adjGold(v);
                else
                    splitGoldAmongParty(v);
                break;
            }
            case SCROLL:{
                SpellType type = SpellType.values()[Util.nextInt(6)];
                Spell spell = new SpellBook().ready(type);
                Scroll scroll = new Scroll(spell);
                if (hero != null)
                    hero.getInventory().add(scroll);
                else {
                    // Find first magic user and give them the scroll
                    for (Hero h: model.getGame().getParty().getHeroes()){
                        if (h.getType() == HeroType.WIZARD || h.getType() == HeroType.ELF || 
                                (h.getType() == HeroType.CLERIC && type == SpellType.BLESSING)){
                            h.getInventory().add(scroll);
                            break;
                        }
                    }
                }
                break;
            }
            case GEM:
            case JEWELRY:
                if (hero != null)
                    hero.getInventory().add(new TreasureEquipment(treasure));
                else
                    model.getGame().getParty().getHeroes().get(0).getInventory().add(new TreasureEquipment(treasure));
                break;
            case MAGIC_TREASURE:{
                Treasure magicTreasure = TreasureTable.getMagicTreasure();
                // TODO What do I do with this?
                break;
            }
            case NOTHING:
            default:
                System.out.println("No treasure found");
                break;
        }
    }

    private void splitGoldAmongParty(int gold){
        int split = gold / model.getGame().getParty().size();
        int remainder = gold % model.getGame().getParty().size();
        // TODO Each dwarf in the party must have at least 1 coin
        for (Hero hero: model.getGame().getParty().getHeroes()){
            int g = split + remainder;
            hero.adjGold(g);
            remainder = 0;
        }
    }


    /**
     * Room is seemingly empty.  Player may choose to search the room
     */
    private void askEmptyRoom(Room room){
        if (room.isSearched())
            return;

        // TODO Ask player if they want to search the room

        RoomContents roomContents = RoomContentsTable.searchEmptyRoom(room.isCorridor());
        System.out.println("You search the room and find " + roomContents);
        if (roomContents != RoomContents.EMPTY){
            handleRoomContents(room);
        }
    }

    /**
     * Spawn a wandering monster
     * Boss Wandering Monsters cannot be final bosses.
     * 
     * Wandering Monsters attack first on first round of combat.
     * Heroes may not use their shield bonus on their first Defense roll
     * If in a corridor, wandering monsters will attack the rearmost two heroes in the marching order
     * If in a room and there are enough monsters, at least one monster will attack each hero.  
     * Extra monsters will attack most hated heroes first, then lowest HP heroes.  Randomly select heroes if ties.
     * All wandering monsters roll morale when the situation calls for it, unless they are monster type that never rolls for morale.
     * @return 
     */
    private void spawnWanderingMonster(Room room){
        Monster monster = MonsterTable.getWanderingMonster();
        monster.addTrait(MonsterTrait.WANDERING);
        room.setMonster(monster);
        encounterRooms.add(room);
    }


    /**
     * Heroes have entered a room with a monster, determine what happens...
     * @param room 
     */
    private void handleEncounter(Room room){
        Monster monster = room.getMonster();
        List<Hero> heroes = model.getGame().getParty().getHeroesInRoom(room);
        if (monster.hasTrait(MonsterTrait.WANDERING)){
            // Monster attacks
            monster.setReaction(Reaction.FIGHT);
            combatEncounter = new CombatEncounter(room, heroes, monster);
            combatEncounter.setHeroesTurn(false);
            model.getGame().setPhaseStep(PhaseStep.PLAY_START_COMBAT);
        }
        else {
            // TODO Ask player whether they want to attack or wait to see what reaction the monster will have
            if (ViewUtil.popupConfirm("Monster Encounter", "Do you want to attack immediately?")){
                // Attack monster first
                monster.setReaction(Reaction.FIGHT);
                combatEncounter = new CombatEncounter(room, heroes, monster);
                model.getGame().setPhaseStep(PhaseStep.PLAY_START_COMBAT);
            }
            else {
                // Wait to see monster's reaction
                Reaction reaction = room.getMonster().rollForReaction();
                monster.setReaction(reaction);
                switch(reaction){
                    case ASK_BRIBE:{
                        int gp = monster.getBribeAmountPerMonster();
                        if (!monster.getType().isBoss()){
                            gp = monster.getBribeAmountPerMonster() * ((Minion) monster).getCount();
                        }
                        if (ViewUtil.popupConfirm("Bribe", "Monster demands " + gp + " GP to pass.  Pay?")){
                            // TODO Subtract GP from heroes
                        }
                        else {
                            monster.setReaction(Reaction.FIGHT);
                            combatEncounter = new CombatEncounter(room, heroes, monster);
                            model.getGame().setPhaseStep(PhaseStep.PLAY_START_COMBAT);
                        }
                        break;
                    }
                    case FIGHT:
                    case FIGHT_TO_DEATH:
                        combatEncounter = new CombatEncounter(room, heroes, monster);
                        model.getGame().setPhaseStep(PhaseStep.PLAY_START_COMBAT);
                        break;
                    case FLEE:
                        ViewUtil.popupNotify("Monster flees the room");
                        room.setMonster(null);
                        break;
                    case FLEE_IF_OUTNUMBERED:
                        int count = 1;
                        if (!monster.getType().isBoss())
                            count = ((Minion) monster).getCount();
                        if (count < heroes.size()){
                            ViewUtil.popupNotify("Monster flees the room");
                            room.setMonster(null);
                        }
                        else {
                            monster.setReaction(Reaction.FIGHT);
                            combatEncounter = new CombatEncounter(room, heroes, monster);
                            model.getGame().setPhaseStep(PhaseStep.PLAY_START_COMBAT);
                        }
                        break;
                    case MAGIC_CHALLENGE:
                        // If party has wizard or magic item allowing to cast spell, duel against monster
                        boolean accepted = false;
                        if (model.getGame().getParty().canCastSpell()){
                            accepted = ViewUtil.popupConfirm("Magic Challenge", "Monster challenges your spellcaster to a duel.  If you win, you get treasure.  If you lose, you lose a level.  Do you accept?");
                        }
                        // Accept:
                        if (accepted){
                            Hero hero = model.getGame().getParty().find(HeroType.WIZARD);
                            if (hero == null)
                                hero = model.getGame().getParty().find(HeroType.ELF);
                            // Roll d6 + wizard level.  If >= monster level, wins.
                            if (Util.roll() + hero.getLevel() >= monster.getLevel()){
                                // Win: monster leaves and wizard gets treasure
                                room.setMonster(null);
                                for (Treasure treasure: monster.getTreasure()){
                                    resolveTreasure(treasure, hero);
                                }
                                ViewUtil.popupNotify("Magic Challenge", "You win the duel!");
                            }
                            else {
                                // Lose: wizard loses a level (may go to level 0 - cannot perform spells), monster attacks
                                hero.adjLevel(-1);
                                combatEncounter = new CombatEncounter(room, heroes, monster);
                                model.getGame().setPhaseStep(PhaseStep.PLAY_START_COMBAT);
                            }
                        }
                        else {
                            // Refuse: monster attacks
                            combatEncounter = new CombatEncounter(room, heroes, monster);
                            model.getGame().setPhaseStep(PhaseStep.PLAY_START_COMBAT);
                        }
                        break;
                    case OFFER_FOOD_REST:
                        ViewUtil.popupNotify("Monster Encounter", "Monster offers food and rest");
                        break;
                    case PEACEFUL:
                        ViewUtil.popupNotify("Monster Encounter", "Monster is peaceful");
                        break;
                    case PUZZLE:
                        ViewUtil.popupNotify("Monster Encounter", "Monster offers a puzzle");
                        break;
                    case QUEST:
                        ViewUtil.popupNotify("Monster Encounter", "Monster offers a quest");
                        break;
                    case SLEEPING:
                        ViewUtil.popupNotify("Monster Encounter", "Monster is sleeping");
                        break;
                    case SPECIAL:
                        break;
                }
            }
        }
    }


    private void doCombatRound(CombatEncounter encounter){
        Monster monster = encounter.getMonster();

        List<Monster> expandedMonsters = new ArrayList<>();
        if (!monster.getType().isBoss()){
            // Could be multiple vermin/minions
            expandedMonsters.addAll(((Minion) monster).expand());
        }
        else {
            expandedMonsters.add(monster);
        }

        Map<Hero, List<Monster>> pairings = new HashMap<>();
        for (Hero hero: encounter.getHeroes()){
            pairings.put(hero, new ArrayList<>());
        }

        for (Monster m: expandedMonsters){
            // Choose Hero to attack
            // If in a room and there are enough monsters, at least one monster will attack each hero.  
            Hero target = null;

            // First choose a Hero that is not being attacked
            for (Hero hero: encounter.getHeroes()){
                if (pairings.get(hero).isEmpty()){
                    target = hero;
                    break;
                }
            }

            if (target == null){
                // Extra monsters will attack most hated heroes first, then lowest HP heroes.  Randomly select heroes if ties.
                // TODO Look for hated heroes

                if (target == null){
                    // Look for lowest HP heroes
                    int lowestHP = 999;
                    List<Hero> lowestHPHeroes = new ArrayList<>();
                    for (Hero hero: encounter.getHeroes()){
                        if (hero.getLifePoints() < lowestHP){
                            lowestHPHeroes.clear();
                            lowestHPHeroes.add(hero);
                        }
                        else if (hero.getLifePoints() == lowestHP){
                            lowestHPHeroes.add(hero);
                        }
                    }
                    target = lowestHPHeroes.get(Util.nextInt(lowestHPHeroes.size()));
                }
            }

            pairings.get(target).add(m);
        }

        if (encounter.isHeroesTurn()){

        }
        else {

        }

        if (encounter.isHeroesTurn()){

        }
        else {

        }
        if (monster.hasTrait(MonsterTrait.WANDERING)){
            // Wandering Monsters attack first on first round of combat.
            // Heroes may not use their shield bonus on their first Defense roll
            // If in a corridor, wandering monsters will attack the rearmost two heroes in the marching order
            // If in a room and there are enough monsters, at least one monster will attack each hero.  
            // Extra monsters will attack most hated heroes first, then lowest HP heroes.  Randomly select heroes if ties.
            // All wandering monsters roll morale when the situation calls for it, unless they are monster type that never rolls for morale.
        }

    }

    private void doCombatHerosTurn(CombatEncounter encounter){
        Monster monster = encounter.getMonster();
    }

    private void doCombatMonsterTurn(CombatEncounter encounter){
        Monster monster = encounter.getMonster();

        List<Monster> expandedMonsters = new ArrayList<>();
        if (!monster.getType().isBoss()){
            // Could be multiple vermin/minions
            expandedMonsters.addAll(((Minion) monster).expand());
        }
        else {
            expandedMonsters.add(monster);
        }

        Map<Monster, Hero> pairings = new HashMap<>();
        Set<Hero> attackedHeroes = new HashSet<>();

        // Set targets
        for (Monster m: expandedMonsters){
            // Choose Hero to attack
            // If in a room and there are enough monsters, at least one monster will attack each hero.  
            Hero target = null;

            // First choose a Hero that is not being attacked
            for (Hero hero: encounter.getHeroes()){
                if (!attackedHeroes.contains(hero)){
                    target = hero;
                    break;
                }
            }

            if (target == null){
                // Extra monsters will attack most hated heroes first, then lowest HP heroes.  Randomly select heroes if ties.
                // TODO Look for hated heroes

                if (target == null){
                    // Look for lowest HP heroes
                    int lowestHP = 999;
                    List<Hero> lowestHPHeroes = new ArrayList<>();
                    for (Hero hero: encounter.getHeroes()){
                        if (hero.getLifePoints() < lowestHP){
                            lowestHPHeroes.clear();
                            lowestHPHeroes.add(hero);
                        }
                        else if (hero.getLifePoints() == lowestHP){
                            lowestHPHeroes.add(hero);
                        }
                    }
                    target = lowestHPHeroes.get(Util.nextInt(lowestHPHeroes.size()));
                }
            }

            pairings.put(m, target);
            attackedHeroes.add(target);
        }

        // Attack Heroes
        for (Monster m: expandedMonsters){
            doMonsterAttackHero(m, pairings.get(m));
        }
    }

    private void doMonsterAttackHero(Monster attacker, Hero defender){
        int numAttacks = attacker.getNumAttacks();
        int damage = attacker.getNumDamagePerAttack();

        for (int i = 0; i < numAttacks; ++i){
            // Roll 1d6
            int v = Util.roll();

            // TODO Modify as necessary

            // If value > monster level, hit is blocked
            // Otherwise, hero suffers damage
            if (v <= attacker.getLevel()){
                defender.adjLifePoints(-damage);
            }
        }
    }
}
