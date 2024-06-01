package com.jomlx.components;

import com.jomlx.widgets.MyButton;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {
    private MigLayout layout;
    private JLabel lblLogo;
    private JLabel lblTitle;
    private JLabel lblDescription;
    private MyButton btnAnimate;
    private ActionListener event;
    private boolean isLogin;
    private final DecimalFormat df = new DecimalFormat("##.0##");
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]5[]25[]push");
        setLayout(layout);
        init();
    }
    
    public void init() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/jomlx/icon/memo-log.png"));
        Image resizedIcon = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel lblIcon = new JLabel(new ImageIcon(resizedIcon));
        lblIcon.setPreferredSize(new Dimension(50, 50));
        add(lblIcon);
        
        lblTitle = new JLabel("Welcom Back");
        lblTitle.setFont(new Font("Sans Serif", 1, 20));
        lblTitle.setForeground(new Color(255, 255, 255));
        add(lblTitle);
        lblDescription = new JLabel("Don't have an account, Register Now!");
        lblDescription.setFont(new Font("Sans Serif", 0, 10));
        lblDescription.setForeground(new Color(255, 255, 255));
        add(lblDescription);
        
        btnAnimate = new MyButton("Register");
        btnAnimate.setBackground(new Color(96,69,240));
        btnAnimate.setDefaultColor(new Color(96,69,240));
        btnAnimate.setLighterColor(new Color(123,100,241));
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

        setBackground(new java.awt.Color(30, 33, 36));
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
    
    public void registerLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(lblTitle, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(lblDescription, "pad 0 -" + v + "% 0 0");
    }
    public void registerRight(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(lblTitle, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(lblDescription, "pad 0 -" + v + "% 0 0");
    }
    
    public void loginLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(lblTitle, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(lblDescription, "pad 0 " + v + "% 0 " + v + "%");
    }
    
     public void loginRight(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(lblTitle, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(lblDescription, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    private void login(boolean login) {
        if (this.isLogin != login) {
            if (login) {
                lblTitle.setText("Join the Fun");
                lblDescription.setText("Sign up and be part of the fun!");
                btnAnimate.setText("Login");
                
            } else {
                lblTitle.setText("Welcome Back");
                lblDescription.setText("Don't have an account? Register Now");
                btnAnimate.setText("Register");
            }
            this.isLogin = login;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
