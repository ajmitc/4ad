package fad.view;

import fad.Model;
import fad.game.combat.CombatEncounter;
import fad.game.combat.HeroCombatAction;
import fad.game.combat.HeroCombatAssignments;
import fad.game.party.Hero;
import fad.game.party.HeroType;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class CombatActionDialog extends BaseDialog{
    private HeroCombatAssignments heroCombatAssignments;

    public CombatActionDialog(Model model, View view, CombatEncounter encounter){
        super(view.getFrame(), "Select Combat Actions", true, 400, 400);

        heroCombatAssignments = new HeroCombatAssignments();
        JPanel content = new JPanel(new GridLayout(encounter.getHeroes().size(), 1));
        for (Hero hero: encounter.getHeroes()){
            heroCombatAssignments.getActions().put(hero, HeroCombatAction.ATTACK);
            content.add(new HeroPanel(hero));
        }

        setContent(content);
        hideCancel();
    }

    public HeroCombatAssignments getHeroCombatAssignments(){
        return heroCombatAssignments;
    }

    private class HeroPanel extends JPanel{
        private Hero hero;

        public HeroPanel(Hero hero){
            super();
            this.hero = hero;

            JComboBox<HeroCombatAction> cbAction = new JComboBox<>();
            cbAction.addItem(HeroCombatAction.ATTACK);
            if (hero.getType() == HeroType.WARRIOR || hero.getType() == HeroType.ELF || hero.getType() == HeroType.CLERIC)
                cbAction.addItem(HeroCombatAction.CAST_SPELL);
            if (hero.getBackSlingItem() != null)
                cbAction.addItem(HeroCombatAction.SWITCH_WEAPON);

            cbAction.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    HeroCombatAction action = (HeroCombatAction) ie.getItem();
                    heroCombatAssignments.getActions().put(hero, action);
                }
            });
        }
    }
}
