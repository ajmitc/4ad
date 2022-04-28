package fad.game.equipment;

public enum EquipmentType {
    WEAPON("weapon"),
    ARMOR("Armor"),
    SHIELD("Shield"),

    BANDAGES("Bandages"),
    HOLY_WATER_VIAL("Holy Water Vial"),
    LANTERN("Lantern"),
    LOCK_PICKS("Lockpicks"),
    ROPE("Rope"),
    SCROLL("Scroll"),
    SPELL_BOOK("Spell Book"),
    TREASURE("Treasure"),
    WRITING_IMPLEMENTS("Writing Implements");

    private String name;
    EquipmentType(String n){
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
