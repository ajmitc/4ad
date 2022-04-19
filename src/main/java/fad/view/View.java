package fad.view;

import fad.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private Model model;
    private JFrame frame;

    public View(Model model){
        this.model = model;
        this.frame = new JFrame();
        frame.setTitle("Four Against Darkness");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLocationRelativeTo(null);
    }

    public Model getModel() {
        return model;
    }

    public JFrame getFrame() {
        return frame;
    }
}
