package com.jomlx.widgets;

import java.awt.*;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class CheckBox extends JCheckBox {
    private Color boxColor;
    private Color textColor;
    
    public CheckBox(String text) {
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        init(text);
        
    }
    
    public final void init(String text) {
        setBackground(new Color(54,57,62));
        setFont(new Font("Sans Serif", 0, 11));
        setForeground(new Color(26,111,255));   
    }
    
    protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
        
    }
    
    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        ButtonModel model = ((JCheckBox) c).getModel();
        g.setColor(boxColor); // Set color for box
        g.fillRect(iconRect.x, iconRect.y, iconRect.width - 1, iconRect.height - 1);
        if (model.isSelected()) {
            g.setColor(textColor); // Set color for selection indicator
            g.fillRect(iconRect.x + 3, iconRect.y + 3, iconRect.width - 6, iconRect.height - 6);
        }
    }
    
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
    }
}
