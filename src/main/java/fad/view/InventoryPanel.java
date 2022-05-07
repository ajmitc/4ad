package fad.view;

import fad.Model;
import fad.game.equipment.Equipment;
import fad.game.party.Hero;
import fad.view.component.AttributeTitleLabel;
import fad.view.component.AttributeValueLabel;

import javax.swing.*;
import java.awt.*;

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
        super(new BorderLayout());
        this.model = model;
        this.view = view;
        this.hero = hero;

        inventoryListModel = new InventoryListModel();
        inventoryList = new JList<>(inventoryListModel);
        lblHand1      = new AttributeValueLabel();
        lblHand2      = new AttributeValueLabel();
        lblBackSling  = new AttributeValueLabel();
        lblArmor      = new AttributeValueLabel();

        inventoryList.setFont(ViewUtil.ATTRIBUTE_VALUE_FONT);

        JLabel lblHand1Title = new AttributeTitleLabel("Right Hand");
        JLabel lblHand2Title = new AttributeTitleLabel("Left Hand");
        JLabel lblBackTitle  = new AttributeTitleLabel("Back Sling");
        JLabel lblArmorTitle = new AttributeTitleLabel("Armor");

        JLabel lblEquippedTitle  = new AttributeTitleLabel("Equipped Items");
        JLabel lblInventoryTitle = new AttributeTitleLabel("Inventory");

        JPanel equippedItemsPanel = new JPanel();
        new GridBagLayoutHelper(equippedItemsPanel)
                .setGridWidth(2)
                .setExternalPadding(0, 0, 10, 0)
                .add(lblEquippedTitle)
                .nextRow()
                .setExternalPadding(0, 10, 5, 0)
                //.setPadding(5, 5)
                .add(lblHand1Title)
                .add(lblHand1)
                .nextRow()
                .add(lblHand2Title)
                .add(lblHand2)
                .nextRow()
                .add(lblBackTitle)
                .add(lblBackSling)
                .nextRow()
                .add(lblArmorTitle)
                .add(lblArmor)
                .nextRow()
                .setGridWidth(2)
                .setExternalPadding(10, 0, 0, 0)
                .add(lblInventoryTitle);

        add(equippedItemsPanel, BorderLayout.NORTH);
        add(new JScrollPane(inventoryList), BorderLayout.CENTER);

        inventoryList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        inventoryList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        inventoryList.setVisibleRowCount(-1);

        refresh();
    }

    public void refresh(){
        lblHand1.setText(hero.getHand1() != null? hero.getHand1().toString(): "None");
        lblHand2.setText(hero.getHand2() != null? hero.getHand2().toString(): "None");
        lblBackSling.setText(hero.getBackSlingItem() != null? hero.getBackSlingItem().toString(): "None");
        lblArmor.setText(hero.getArmor() != null? hero.getArmor().toString(): "None");

        for (Equipment item: hero.getInventory()){
            inventoryListModel.addElement(item);
        }
    }
}
