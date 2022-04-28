package fad.view;

import fad.Model;
import fad.game.party.Hero;
import java.awt.Color;
import java.awt.Dimension;
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
    private JLabel lblMaxLifePoints;
    private JButton btnCastSpell;
    private JLabel lblReadiedSpells;
    private JLabel lblMaxReadiedSpells;

    public HeroPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        setPreferredSize(new Dimension(400, 300));

        lblName = new JLabel();
        lblHeroType = new JLabel();
        lblAttackType = new JLabel();
        lblDefenseType = new JLabel();
        lblGold = new JLabel();
        lblLevel = new JLabel();
        lblLifePoints = new JLabel();
        lblMaxLifePoints = new JLabel();
        lblReadiedSpells = new JLabel();
        lblMaxReadiedSpells = new JLabel();

        btnOpenInventory = new JButton("Inventory");
        btnCastSpell = new JButton("Cast Spell");

        JLabel lblAttackTitle = new JLabel("Attack: ");
        JLabel lblDefenseTitle = new JLabel("Defense: ");
        JLabel lblGoldTitle = new JLabel("Gold: ");
        JLabel lblLevelTitle = new JLabel("Level ");
        JLabel lblLifePointsTitle = new JLabel("HP: ");
        JLabel lblMaxLifePointsTitle = new JLabel("/");
        JLabel lblReadiedSpellsTitle = new JLabel("Spells: ");
        JLabel lblMaxReadiedSpellsTitle = new JLabel("Max Spells: ");

        // Layout panel
        new GridBagLayoutHelper(this)
                .setGridWidth(6)
                .add(lblName)
                .nextRow()

                .resetGridWidth()
                .add(lblLevelTitle)
                .add(lblLevel)
                .setGridWidth(4)
                .add(lblHeroType)
                .nextRow()

                .resetGridWidth()
                .add(lblAttackTitle)
                .setGridWidth(2)
                .add(lblAttackType)
                .setGridWidth(1)
                .add(lblDefenseTitle)
                .setGridWidth(2)
                .add(lblDefenseType)
                .nextRow()

                .resetGridWidth()
                .add(lblGoldTitle)
                .add(lblGold)
                .add(lblLifePointsTitle)
                .add(lblLifePoints)
                .add(lblMaxLifePointsTitle)
                .add(lblMaxLifePoints)
                .nextRow()

                .resetGridWidth()
                .add(lblReadiedSpellsTitle)
                .setGridWidth(2)
                .add(lblReadiedSpells)
                .setGridWidth(1)
                .add(lblMaxReadiedSpellsTitle)
                .setGridWidth(2)
                .add(lblMaxReadiedSpells)
                .nextRow()

                .resetGridWidth()
                .setGridWidth(3)
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
        lblLevel.setText("" + hero.getLevel());
        lblLifePoints.setText("" + hero.getLifePoints());
        lblMaxLifePoints.setText("" + hero.getMaxLifePoints());
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
