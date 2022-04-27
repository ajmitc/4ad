package fad.view;

import fad.Model;
import fad.game.party.Hero;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

/**
 *
 * @author aaron.mitchell
 */
public class HeroSelectionDialog extends BaseDialog{
    private JList<Hero> heroList;
    private HeroListModel listModel;
    private boolean selectOne;

    public HeroSelectionDialog(Model model, View view, List<Hero> heroes, boolean selectOne){
        super(view.getFrame(), "Select Hero", true, 400, 400);
        this.selectOne = selectOne;

        if (heroes == null || heroes.isEmpty()){
            heroes = model.getGame().getParty().getHeroes();
        }

        JPanel contentPanel = new JPanel(new BorderLayout());

        listModel = new HeroListModel();

        for (Hero hero: heroes){
            listModel.addElement(hero);
        }

        HeroPanelRenderer renderer = new HeroPanelRenderer();

        heroList = new JList<>(listModel);
        heroList.setSelectionMode(selectOne? ListSelectionModel.SINGLE_SELECTION: ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        heroList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        heroList.setVisibleRowCount(-1);
        heroList.setCellRenderer(renderer);
        contentPanel.add(new JScrollPane(heroList));

        setContent(contentPanel);
        this.setCloseText("Select");
    }

    private void deselectAll(){
        heroList.setSelectedValue(null, false);
    }

    public Hero getSelectedHero(){
        return heroList.getSelectedValuesList().get(0);
    }

    public List<Hero> getSelectedHeroes(){
        return heroList.getSelectedValuesList();
    }

    private static class HeroListModel extends DefaultListModel{
        
    }

    private static class HeroPanelRenderer implements ListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList jlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            HeroPanel heroPanel = new HeroPanel((Hero) value);
            heroPanel.setSelected(isSelected);
            return heroPanel;
        }

    }

    private static class HeroPanel extends JPanel{
        private Hero hero;
        private boolean selected = false;
        private final Border selectedBorder;
        private final Border plainBorder;

        public HeroPanel(Hero hero){
            super();
            this.hero = hero;

            selectedBorder = BorderFactory.createLineBorder(Color.yellow);
            plainBorder = BorderFactory.createEmptyBorder();

            JLabel lblName = new JLabel(hero.getName() + " (" + hero.getType() + ")");
            add(lblName);

            setBorder(plainBorder);
        }

        public void setSelected(boolean v){
            this.selected = v;
            this.setBorder(this.selected? selectedBorder: plainBorder);
        }

        public boolean isSelected(){ return this.selected; }

        public Hero getHero(){ return this.hero; }
    }
}
