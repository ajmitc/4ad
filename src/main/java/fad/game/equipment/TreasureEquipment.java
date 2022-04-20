package fad.game.equipment;

import fad.game.chart.Treasure;

/**
 *
 * @author aaron.mitchell
 */
public class TreasureEquipment extends Equipment{
    private final Treasure treasure;

    public TreasureEquipment(Treasure treasure){
        super(treasure.getName(), EquipmentType.TREASURE);
        this.treasure = treasure;
    }

    public Treasure getTreasure() {
        return treasure;
    }
}
