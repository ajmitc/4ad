package fad.view;

import fad.Model;
import fad.game.party.Hero;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class PartyPanel extends JPanel{
    private Model model;
    private View view;

    private List<HeroPanel> heroPanels = new ArrayList<>();

    public PartyPanel(Model model, View view){
        super(new GridLayout(4, 1));
        this.model = model;
        this.view = view;

        heroPanels.add(new HeroPanel(model, view));
        heroPanels.add(new HeroPanel(model, view));
        heroPanels.add(new HeroPanel(model, view));
        heroPanels.add(new HeroPanel(model, view));

        for (HeroPanel heroPanel: heroPanels){
            add(heroPanel);
        }
    }

    public void assignHeroes(){
        for (int i = 0; i < model.getGame().getParty().getHeroes().size(); ++i){
            Hero hero = model.getGame().getParty().getHeroes().get(i);
            heroPanels.get(i).setHero(hero);
        }
    }

    public void refresh(){
        for (HeroPanel heroPanel: heroPanels){
            heroPanel.refresh();
        }
    }
}
