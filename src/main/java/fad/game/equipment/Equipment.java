package fad.game.equipment;

public class Equipment {
    private String name;
    private EquipmentType type;
    private boolean ranged = false;
    // Number of slots used by this equipment
    // ie. 1-one handed weapon, 2- two handed weapon
    // Two-handed weapons give a +1 attack rolls
    private int numSlotUsage = 1;
    // Light weapons give -1 on Attack rolls
    // Light armor gives +1 on Defense rolls (certain attacks from monsters ignore this bonus)
    //   May be re-assigned to another Hero (of same species) if wearer dies
    // Heavy armor adds +2 to Defense rolls (Certain attacks from monsters ignore this bonus)
    //   Makes Hero slow - negative modifier on Save rolls
    //   May not be re-assigned to another Hero if wearer dies
    private EquipmentWeight weight = EquipmentWeight.NORMAL;

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
