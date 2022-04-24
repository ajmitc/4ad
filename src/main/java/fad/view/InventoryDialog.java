package fad.view;

import fad.Model;
import fad.game.party.Hero;

/**
 *
 * @author aaron.mitchell
 */
public class InventoryDialog extends BaseDialog{
    public InventoryDialog(Model model, View view, Hero hero){
        super(view.getFrame(), "Inventory", true, 400, 400);
        this.hideCancel();

        InventoryPanel panel = new InventoryPanel(model, view, hero);
        setContent(panel);
    }
}
