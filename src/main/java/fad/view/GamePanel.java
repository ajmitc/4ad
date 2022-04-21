package fad.view;

import fad.Model;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class GamePanel extends JPanel{
    private Model model;
    private View view;

    public GamePanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;
    }

    public void refresh(){

    }
}
