package com.jomlx.widgets;

import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class PasswordField extends JPasswordField {
    private String hint = "";
    private Icon leftIcon;
    
    public PasswordField() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        if(getText().length() == 0) {
            int height = getHeight();
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int bg = getBackground().getRGB();
            int fg = getForeground().getRGB();
            int m = 0xfefefefe;
            int color = ((bg&m)>>>1) + ((fg&m)>>>1);
            g.setColor(new Color(color, true));
            g.drawString(getHint(), ins.left, height / 2 + fm.getAscent() / 2 -2);
        }
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);
    }
    
    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (leftIcon != null) {
            Image prefix =((ImageIcon) leftIcon).getImage();
            int y = (getHeight() - leftIcon.getIconHeight());
            g2.drawImage(prefix, 0, y, this);
        }
    }
    
    private void initBorder() {
        int left = 5;
        int right =5;     
        if (leftIcon != null) {
            left = leftIcon.getIconWidth();
        }
        
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
        
    }
    
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Icon getLeftIcon() {
        return leftIcon;
    }

    public void setLeftIcon(Icon leftIcon) {
        this.leftIcon = leftIcon;
        initBorder();
    }
    
}
