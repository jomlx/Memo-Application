package com.jomlx.widgets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class MyButton extends JButton {
    private final int radius = 0;
    
    public MyButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }
    
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        g2.setColor(getForeground());
        
        super.paintComponent(g);
        g2.dispose();
    }
}