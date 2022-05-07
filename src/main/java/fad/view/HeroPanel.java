package fad.view;

import fad.Model;
import fad.game.party.Hero;
import fad.view.component.AttributeTitleLabel;
import fad.view.component.AttributeValueLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class HeroPanel extends JPanel{
    private Model model;
    private View view;
    private Hero hero;

    private JLabel lblName;
    private JLabel lblHeroType;
    private JLabel lblAttackType;
    private JLabel lblDefenseType;
    private JButton btnOpenInventory;
    private JLabel lblGold;
    private JLabel lblLevel;
    private JLabel lblLifePoints;
    private JButton btnCastSpell;
    private JLabel lblReadiedSpells;
    private JLabel lblMaxReadiedSpells;

    public HeroPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        setPreferredSize(new Dimension(400, 300));

        lblName = new JLabel();
        lblHeroType = new AttributeValueLabel();
        lblAttackType = new AttributeValueLabel();
        lblDefenseType = new AttributeValueLabel();
        lblGold = new AttributeValueLabel();
        lblLevel = new AttributeValueLabel();
        lblLifePoints = new AttributeValueLabel();
        lblReadiedSpells = new AttributeValueLabel();
        lblMaxReadiedSpells = new AttributeValueLabel();

        lblName.setFont(new Font("Serif", Font.BOLD, 16));

        btnOpenInventory = new JButton("Inventory");
        btnCastSpell = new JButton("Cast Spell");

        JLabel lblAttackTitle = new AttributeTitleLabel("Attack: ");
        JLabel lblDefenseTitle = new AttributeTitleLabel("Defense: ");
        JLabel lblGoldTitle = new AttributeTitleLabel("Gold: ");
        //JLabel lblLevelTitle = new AttributeTitleLabel("Level ");
        JLabel lblLifePointsTitle = new AttributeTitleLabel("HP: ");
        JLabel lblReadiedSpellsTitle = new AttributeTitleLabel("Spells: ");
        JLabel lblMaxReadiedSpellsTitle = new AttributeTitleLabel("Max Spells: ");

        // Layout panel
        new GridBagLayoutHelper(this)
                .setGridWidth(2)
                .add(lblName)
                //.add(lblLevelTitle)
                .setGridWidth(1)
                .add(lblLevel)
                .add(lblHeroType)
                .nextRow()

                .resetGridWidth()
                .add(lblAttackTitle)
                .add(lblAttackType)
                .add(lblDefenseTitle)
                .add(lblDefenseType)
                .nextRow()

                .resetGridWidth()
                .add(lblGoldTitle)
                .add(lblGold)
                .add(lblLifePointsTitle)
                .add(lblLifePoints)
                .nextRow()

                .resetGridWidth()
                .add(lblReadiedSpellsTitle)
                .add(lblReadiedSpells)
                .add(lblMaxReadiedSpellsTitle)
                .add(lblMaxReadiedSpells)
                .nextRow()

                .resetGridWidth()
                .setGridWidth(2)
                .add(btnOpenInventory)
                .add(btnCastSpell)
                ;

        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void refresh(){
        if (hero == null)
            return;
        lblName.setText(hero.getName());
        lblHeroType.setText(hero.getType().getName());
        lblAttackType.setText(hero.getAttackType().getName());
        lblDefenseType.setText(hero.getDefenseType().getName());
        lblGold.setText("" + hero.getGold());
        lblLevel.setText("Level " + hero.getLevel());
        lblLifePoints.setText(hero.getLifePoints() + "/" + hero.getMaxLifePoints());
        lblReadiedSpells.setText(hero.getReadiedSpells().stream().map(spell -> spell.getType().getName()).collect(Collectors.joining(", ")));
        lblMaxReadiedSpells.setText("" + hero.getMaxReadiedSpells());
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
        this.btnOpenInventory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                InventoryDialog d = new InventoryDialog(model, view, hero);
                d.setVisible(true);
            }
        });
        refresh();
    }
}
