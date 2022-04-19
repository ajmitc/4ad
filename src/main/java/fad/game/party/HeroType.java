package fad.game.party;

public enum HeroType {
    BARBARIAN("Barbarian"),
    DWARF("Dwarf"),
    ELF("Elf"),
    HALFLING("Halfling"),
    ROGUE("Rogue"),
    WARRIOR("Warrior"),
    WIZARD("Wizard");

    private String name;
    HeroType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
