package fad.view;

import fad.Model;
import fad.game.party.Hero;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

        btnOpenInventory = new JButton();
        btnCastSpell = new JButton();

        // Layout panel
        //new GridBagLayoutHelper(this)
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
        refresh();
    }
}
