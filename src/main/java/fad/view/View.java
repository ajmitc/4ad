package fad.view;

import fad.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private static final String MAIN_MENU = "mainmenu";
    private static final String GAME = "game";

    private Model model;
    private JFrame frame;

    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;

    public View(Model model){
        this.model = model;
        this.frame = new JFrame();
        frame.setTitle("Four Against Darkness");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLocationRelativeTo(null);

        mainMenuPanel = new MainMenuPanel(model, this);
        gamePanel     = new GamePanel(model, this);

        frame.getContentPane().setLayout(new CardLayout());
        frame.getContentPane().add(mainMenuPanel, MAIN_MENU);
        frame.getContentPane().add(gamePanel, GAME);
    }

    public void refresh(){
        gamePanel.refresh();    
    }

    public void showMainMenu(){
        showPanel(MAIN_MENU);
    }

    public void showGame(){
        showPanel(GAME);
    }

    private void showPanel(String name){
        CardLayout layout = (CardLayout) frame.getContentPane().getLayout();
        layout.show(frame.getContentPane(), name);
    }

    public Model getModel() {
        return model;
    }

    public JFrame getFrame() {
        return frame;
    }

    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
