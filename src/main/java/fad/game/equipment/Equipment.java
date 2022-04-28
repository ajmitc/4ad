package fad.game.equipment;

public class Equipment {
    private String name;
    private EquipmentType type;
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

    // Number of times this item can be used before it is discarded
    // A value of -1 is permanent
    private int numUses = -1;

    public Equipment(){}

    public Equipment(String name, EquipmentType type){
        this(name, type, EquipmentWeight.NORMAL);
    }

    public Equipment(String name, EquipmentType type, EquipmentWeight weight){
        this.name = name;
        this.type = type;
        this.weight = weight;
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

    public int getNumSlotUsage() {
        return numSlotUsage;
    }

    public void setNumSlotUsage(int numSlotUsage) {
        this.numSlotUsage = numSlotUsage;
    }

    public EquipmentWeight getWeight() {
        return weight;
    }

    public void setWeight(EquipmentWeight weight) {
        this.weight = weight;
    }

    public int getNumUses() {
        return numUses;
    }

    public void setNumUses(int numUses) {
        this.numUses = numUses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append("(");
        sb.append(type);
        sb.append(")");
        if ((this instanceof Weapon) && ((Weapon) this).getAttackType() == WeaponAttackType.RANGED)
            sb.append(" RANGED");
        if (weight != EquipmentWeight.NORMAL){
            sb.append(" ");
            sb.append(weight);
        }
        if (numUses != 1){
            sb.append(" x");
            sb.append(numUses);
        }
        return sb.toString();
    }
}
