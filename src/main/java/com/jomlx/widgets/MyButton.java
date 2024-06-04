package com.jomlx.widgets;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public final class MyButton extends JButton {
 
    private final int radius = 0;
    private Color defaultColor;
    private Color lighterColor;
    private Dimension defaultSize;
    private String label = "";
    
    public MyButton() {
        setForeground(new Color(255, 255, 255));
        setFont(new Font("Sans Serif", 1, 11));
        setContentAreaFilled(false);
        init();
    }
    
    public void init() {
        defaultSize = getPreferredSize();
        
        addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
                setBackground(lighterColor);
                enlargeButton();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(defaultColor);
                resetSize();
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
    
    private void enlargeButton() {
        if (defaultSize != null) {
            defaultSize = getPreferredSize();
        }
        Dimension largeSize = new Dimension(defaultSize.width + 1, defaultSize.height + 1);
        setPreferredSize(largeSize);
        revalidate();
    }
    
    private void resetSize() {
        if (defaultSize != null) {
            setPreferredSize(defaultSize);
            setSize(defaultSize);
            revalidate();
        }
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
        setBackground(defaultColor);
    }

    public Color getLighterColor() {
        return lighterColor;
    }

    public void setLighterColor(Color lighterColor) {
        this.lighterColor = lighterColor;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}