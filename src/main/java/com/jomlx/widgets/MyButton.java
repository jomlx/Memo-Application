package com.jomlx.widgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MyButton extends JButton {
    private final int radius = 0;
    private Color defaultColor;
    private Color lighterColor;
    
    public MyButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFont(new Font("gg Sans", 1, 11));
        setForeground(new Color(255, 255, 255));
        defaultColor = getBackground();
        Dimension defaultSize = getPreferredSize();
        Dimension largerSize = new Dimension(defaultSize.width + 1, defaultSize.height + 1);
        addMouseListener(new MouseAdapter() {
           public void mousePressed(MouseEvent e) {
                setBackground(lighterColor);
                setPreferredSize(largerSize);
                revalidate(); // Update the button size
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(defaultColor);
                setPreferredSize(defaultSize);
                revalidate(); // Revert to the original size
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(lighterColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultColor); 
            }
        });
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

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public Color getLighterColor() {
        return lighterColor;
    }

    public void setLighterColor(Color lighterColor) {
        this.lighterColor = lighterColor;
    }
}