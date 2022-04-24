package fad.view;

import fad.Model;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class DungeonPanel extends JPanel{
    private Model model;
    private View view;

    public DungeonPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;
    }

    public void refresh(){

    }

    @Override
    public void paintComponent(Graphics graphics){
        if (model.getGame() == null){
            return;
        }

        Graphics2D g = (Graphics2D) graphics;

    }
}
