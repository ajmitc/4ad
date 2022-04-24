package fad;

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
import fad.game.equipment.Scroll;
import fad.game.equipment.SpellBook;
import fad.game.equipment.TreasureEquipment;
import fad.game.party.Hero;
import fad.game.party.HeroType;
import fad.game.spell.Spell;
import fad.game.spell.SpellType;
import fad.game.monster.Boss;
import fad.game.monster.Minion;
import fad.util.Util;
import fad.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

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
            }
        }
    }

    public void createDungeon(){
        Room entrance = RoomFactory.createEntranceRoom();
        model.getGame().getDungeon().getRooms().add(entrance);

        // Add rooms off all entrance connection points
        model.getGame().getDungeon().addConnectingRooms(entrance);
    }

    public void goThroughDoor(){
        // Roll d66 for room
        Room room = RoomFactory.createRoom();
        // Add room to dungeon
        model.getGame().getDungeon().getRooms().add(room);

        // TODO Move party into room

        // Get Room Contents
        RoomContents roomContents = RoomContentsTable.getRoomContents();
        room.setRoomContents(roomContents);
        handleRoomContents(room);
    }

    public void handleRoomContents(Room room){
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
                System.out.println("You find a " + vermin.getType());
                // Ask if heros want to attack or wait to see what the monster does
                break;
            }
            case MINION:{
                // Roll on minions table
                Minion minion = MonsterTable.getMinion();
                break;
            }
            case MINION_IF_ROOM:{
                // if room, roll on minions table.  Then, if win, Roll on Treasure table
                if (!room.isCorridor()){
                    Minion minion = MonsterTable.getMinion();

                }
                // if corridor, Empty
                else {
                    System.out.println("Corridor is empty");
                }
                break;
            }
            case EMPTY:
                System.out.println("Room is empty");
                break;
            case WIERD_MONSTER_IF_ROOM:{
                // if room, Roll on Weird Monster table.  If win, Roll for leveling up and roll on treasure table
                if (!room.isCorridor()){
                    Boss monster = MonsterTable.getWeirdMonster();

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
                // if room, maybe final Boss
                break;
            }
            case SMALL_DRAGONS_LAIR:{
                // if room, this is a Small Dragon's Lair (see boss table).  If win, roll for leveling up and roll on treasure table
                // if corridor, empty
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
}
