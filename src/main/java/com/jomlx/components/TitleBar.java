package com.jomlx.components;

import com.jomlx.memo.Main;
import com.jomlx.widgets.MyButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;

public class TitleBar extends JPanel {
    private MigLayout layout;
    
    public TitleBar() {
        setOpaque(false);
        setPreferredSize(new Dimension(600, 25));
        init();
    }
    
    private void init() {
        layout = new MigLayout("insets 0 10 0 0, fill", "[left]push[]0[]");
        setLayout(layout);
        
        String close = "/com/jomlx/icon/dispose.png";
        String minimize = "/com/jomlx/icon/minimize.png";
        
        MyButton btnClose = addButton(close, new Color(255, 32, 21));        
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getMainFrame().dispose();
            }
        });
        
        MyButton btnMinimize = addButton(minimize, new Color(74,76,81));
        btnMinimize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getMainFrame().setState(Frame.ICONIFIED);
            }
        });
        
        JLabel lblName = new JLabel("MEMO");
        lblName.setFont(new Font("Sans Serif", 1, 10));
        lblName.setForeground(new Color(255, 255, 255));
        
        add(lblName, "align left");
        add(btnMinimize, "w 25!, h 20!, align right");
        add(btnClose, "w 25!, h 20!, align right");
    }
    
    private MyButton addButton(String path, Color lighterColor) {
        MyButton button = new MyButton();
        button.setBackground(new Color(30, 33, 36));
        button.setDefaultColor(new Color(30, 33, 36));
        button.setLighterColor(lighterColor);
        
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image resizedImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        button.setIcon(resizedIcon);
        return button;
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setPaint(new Color(30,33,36));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
