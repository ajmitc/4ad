package fad.view;

import fad.Model;
import fad.game.equipment.Equipment;
import fad.game.party.Hero;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author aaron.mitchell
 */
public class InventoryPanel extends JPanel{
    private Model model;
    private View view;
    private Hero hero;

    private InventoryListModel inventoryListModel;
    private JList<Equipment> inventoryList;
    private JLabel lblHand1;
    private JLabel lblHand2;
    private JLabel lblBackSling;
    private JLabel lblArmor;

    public InventoryPanel(Model model, View view, Hero hero){
        super();
        this.model = model;
        this.view = view;
        this.hero = hero;

        inventoryListModel = new InventoryListModel();
        inventoryList = new JList<>(inventoryListModel);
        lblHand1      = new JLabel();
        lblHand2      = new JLabel();
        lblBackSling  = new JLabel();
        lblArmor      = new JLabel();

        inventoryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        inventoryList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        inventoryList.setVisibleRowCount(-1);

        for (Equipment item: hero.getInventory()){
            inventoryListModel.addElement(item);
        }

        lblHand1.setText(hero.getHand1() != null? hero.getHand1().toString(): "None");
        lblHand2.setText(hero.getHand2() != null? hero.getHand2().toString(): "None");
        lblBackSling.setText(hero.getBackSlingItem() != null? hero.getBackSlingItem().toString(): "None");
        lblArmor.setText(hero.getArmor() != null? hero.getArmor().toString(): "None");
    }    
}
