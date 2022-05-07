package fad.view.component;

import fad.view.ViewUtil;

import javax.swing.*;

public class AttributeTitleLabel extends JLabel {
    public AttributeTitleLabel(){
        super();
        setFont(ViewUtil.ATTRIBUTE_TITLE_FONT);
    }

    public AttributeTitleLabel(String text){
        super(text);
        setFont(ViewUtil.ATTRIBUTE_TITLE_FONT);
    }
}
