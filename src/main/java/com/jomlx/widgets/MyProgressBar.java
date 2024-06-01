package com.jomlx.widgets;

import java.awt.*;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class MyProgressBar extends JProgressBar{
    private Color stringColor = new Color(200, 200, 200);
    
    public MyProgressBar() {
        setStringPainted(true);
        setPreferredSize(new Dimension(150, 10));
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(123, 100, 241));
        setUI(new BasicProgressBarUI(){            
            @Override
            protected void paintString(Graphics graphics, int i, int i1, int i2, int i3, int i4, Insets insets) {
                graphics.setColor(getStringColor());
                super.paintString(graphics, i, i1, i2, i3, i4, insets);
            }
        });
    }
    
    public Color getStringColor() {
        return stringColor;
    }

    public void setStringColor(Color stringColor) {
        this.stringColor = stringColor;
    }
}
