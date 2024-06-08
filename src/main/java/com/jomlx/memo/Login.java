package com.jomlx.memo;

import com.jomlx.components.LoadingScreen;
import com.jomlx.database.User;
import com.jomlx.service.FieldValidator;
import com.jomlx.service.Hash;
import com.jomlx.user.UserValidator;
import com.jomlx.widgets.MyButton;
import com.jomlx.widgets.PasswordField;
import com.jomlx.widgets.TextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
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
        setLayout(new MigLayout("wrap, align center", "center", "push[]25[]5[]1[]25[]push"));
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
        
        JCheckBox showPassword = new JCheckBox("Show password");
        showPassword.setFont(new Font("Sans Serif", 0, 11));
        showPassword.setForeground(new Color(85,136,255));
        showPassword.setFocusPainted(false);
        showPassword.setOpaque(false);
        showPassword.setBorderPainted(false);
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    // Show password
                    txtPassword.setEchoChar((char) 0);
                } else {
                    // Hide password
                    txtPassword.setEchoChar('•');
                }
            }
        });
        add(showPassword, "align left");
        
        btnLogin = new MyButton();
        btnLogin.setText("Login");
        btnLogin.setFont(new Font("gg Sans", 1, 12));
        btnLogin.setDefaultColor(new Color(11, 96, 176));
        btnLogin.setLighterColor(new Color(14, 122, 224));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String email = txtEmail.getText();
                char[] hashPassword = txtPassword.getPassword();
                String password = Hash.hashPassword(hashPassword);
                
                if (fieldRequired(txtEmail,txtPassword)) {
                    if (UserValidator.verifyLogin(email, password)) {
                        Main frame = Main.getMainFrame();
                        frame.setVisible(false);
                        new LoadingScreen().setVisible(true);
                        frame.dispose();
                        System.out.println("Login Successfully");
                        
                        txtEmail.setText("");
                        txtPassword.setText("");
                    }
                }
            }
        });
        add(btnLogin, "width 70%");
    }
    
    public static boolean fieldRequired(TextField email, PasswordField password) {
        if (FieldValidator.isFieldEmpty(email)) {
            FieldValidator.showMessage("email");
            return false;
        }
        if (FieldValidator.isFieldEmpty(password)) {
            FieldValidator.showMessage("password");
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(47, 49, 54));
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
