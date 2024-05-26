package com.jomlx.memo;

import com.jomlx.widgets.MyButton;
import com.jomlx.widgets.PasswordField;
import com.jomlx.widgets.TextField;
import java.awt.*;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Login extends javax.swing.JPanel {
    private MyButton btnLogin;
    private TextField txtEmail;
    private PasswordField txtPassword;
    public Login() {
        initComponents();
        initLogin();
    }
    
    public void initLogin() {
        setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]5[]25[]push"));
        JLabel lblTitle = new JLabel("Login");
        lblTitle.setFont(new Font("Sans Serif", 1, 35));
        lblTitle.setForeground(new Color(250, 250, 250));
        add(lblTitle);

        txtEmail = new TextField();;
        txtEmail.setHint("EMAIL OR USERNAME");
        txtEmail.setFont(new Font("Sans Serif", 1, 11));
        txtEmail.setBackground(new Color(30,33,36));
        txtEmail.setForeground(new Color(255, 255, 255));
        add(txtEmail, "width 72%, height 9%");
        
        txtPassword = new PasswordField();
        txtPassword.setHint("PASSWORD");
        txtPassword.setFont(new Font("Sans Serif", 1, 11));
        txtPassword.setBackground(new Color(30,33,36));
        txtPassword.setForeground(new Color(255, 255, 255));
        add(txtPassword, "width 72%, height 9%");
        
        btnLogin = new MyButton("Login");
        btnLogin.setFont(new Font("gg Sans", 1, 12));
        btnLogin.setBackground(new Color(123,100,241));
        btnLogin.setForeground(new Color(255, 255, 255));
        add(btnLogin, "width 70%");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(54, 57, 62));
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
        g2.setPaint(new Color(54,57,62));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(graphics);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
