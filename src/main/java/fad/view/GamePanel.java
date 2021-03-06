package fad.view;

import fad.Model;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class GamePanel extends JPanel{
    private Model model;
    private View view;

    private PartyPanel partyPanel;
    private DungeonPanel dungeonPanel;

    public GamePanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        partyPanel = new PartyPanel(model, view);
        dungeonPanel = new DungeonPanel(model, view);

        add(dungeonPanel, BorderLayout.CENTER);
        add(partyPanel, BorderLayout.EAST);
    }

    public void refresh(){
        partyPanel.refresh();
        dungeonPanel.refresh();
    }

    public PartyPanel getPartyPanel() {
        return partyPanel;
    }

    public DungeonPanel getDungeonPanel() {
        return dungeonPanel;
    }
}
