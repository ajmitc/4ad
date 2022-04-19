package fad.game.equipment;

public class Equipment {
    private String name;
    private EquipmentType type;
    private boolean ranged = false;

    public Equipment(){}

    public Equipment(String name, EquipmentType type){
        this(name, type, false);
    }

    public Equipment(String name, EquipmentType type, boolean ranged){
        this.name = name;
        this.type = type;
        this.ranged = ranged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public boolean isRanged() {
        return ranged;
    }

    public void setRanged(boolean ranged) {
        this.ranged = ranged;
    }
}
