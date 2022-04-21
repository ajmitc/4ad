package fad.view;

import fad.Model;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aaron.mitchell
 */
public class MainMenuPanel extends JPanel{
    private Model model;
    private View view;

    private JButton btnExit;
    private JButton btnNewGame;

    public MainMenuPanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        btnExit = new JButton("Exit");
        btnNewGame = new JButton("New Game");

        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new BoxLayout(btnpanel, BoxLayout.PAGE_AXIS));
        btnpanel.add(btnNewGame);
        btnpanel.add(btnExit);

        add(btnpanel, BorderLayout.CENTER);
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnNewGame() {
        return btnNewGame;
    }
}
