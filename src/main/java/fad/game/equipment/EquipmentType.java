package fad.game.equipment;

public enum EquipmentType {
    ONE_HAND_WEAPON("One-handed weapon"),
    TWO_HAND_WEAPON("Two-handed weapon"),
    LIGHT_ARMOR("Light Armor"),
    HEAVY_ARMOR("Heavy Armor"),
    LANTERN("Lantern");

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