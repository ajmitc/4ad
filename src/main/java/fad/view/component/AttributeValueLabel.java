package fad.view.component;

import fad.view.ViewUtil;

import javax.swing.*;

public class AttributeValueLabel extends JLabel {
    public AttributeValueLabel(){
        super();
        setFont(ViewUtil.ATTRIBUTE_VALUE_FONT);
    }

    public AttributeValueLabel(String text){
        super(text);
        setFont(ViewUtil.ATTRIBUTE_VALUE_FONT);
    }
}
