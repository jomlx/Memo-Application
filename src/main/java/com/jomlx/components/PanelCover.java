package com.jomlx.components;

import com.jomlx.widgets.MyButton;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {
    private MigLayout layout;
    private MyButton btnAnimate;
    private ActionListener event;
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]5[]5[]25[]push");
        setLayout(layout);
        init();
    }
    
    public void init() {
        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/com/jomlx/icon/memo.png")));
        add(lblLogo);
        
        JLabel lblTitle = new JLabel("Welcom Back");
        lblTitle.setFont(new Font("Sans Serif", 1, 20));
        lblTitle.setForeground(new Color(255, 255, 255));
        add(lblTitle);
        JLabel lblDescript = new JLabel("Don't have an account, Register Now!");
        lblDescript.setFont(new Font("Sans Serif", 0, 10));
        lblDescript.setForeground(new Color(255, 255, 255));
        add(lblDescript);
        
        btnAnimate = new MyButton("Register");
        btnAnimate.setFont(new Font("Sans Serif", 1, 12));
        btnAnimate.setBackground(new Color(96,69,240));
        btnAnimate.setForeground(new Color(255, 255, 255));
        btnAnimate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }
        });
        add(btnAnimate);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setPaint(new Color(30, 33, 36));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(graphics);
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
