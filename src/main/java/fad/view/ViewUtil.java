package fad.view;

import javax.swing.*;
import java.awt.*;

public class ViewUtil {
    public static final String FONT_FAMILY = "Serif";
    public static final Font ATTRIBUTE_TITLE_FONT = new Font(FONT_FAMILY, Font.BOLD, 14);
    public static final Font ATTRIBUTE_VALUE_FONT = new Font(FONT_FAMILY, Font.PLAIN, 14);

    public static void popupNotify(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static void popupNotify(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static boolean popupConfirm(String title, String message){
        int ret = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        return ret >= 1;
    }

    private ViewUtil(){}
}
