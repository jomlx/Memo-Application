package com.jomlx.widgets;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JLabel;

public class MyLabel extends JLabel {
    private Color defaultColor;
    private Color lighterColor;
    public MyLabel(Icon icon) {
        defaultColor = new Color(255, 255, 255);
        lighterColor = new Color(255, 255, 255);
        Dimension defaultSize = getPreferredSize();
        Dimension largerSize = new Dimension(defaultSize.width + 1, defaultSize.height + 1);
        addMouseListener(new MouseAdapter() {
           public void mousePressed(MouseEvent e) {
                setForeground(defaultColor);
                setPreferredSize(largerSize);
                revalidate(); // Update the button size
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setForeground(defaultColor);
                setPreferredSize(defaultSize);
                revalidate(); // Revert to the original size
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(lighterColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(defaultColor); 
            }
        });

    }
}
