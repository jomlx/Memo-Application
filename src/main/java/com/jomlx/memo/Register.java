package com.jomlx.memo;

import com.jomlx.components.OTPDialog;
import com.jomlx.service.AuthCode;
import com.jomlx.service.FieldValidator;
import com.jomlx.service.Hash;
import com.jomlx.service.MailService;
import com.jomlx.user.UserValidator;
import com.jomlx.widgets.MyButton;
import com.jomlx.widgets.PasswordField;
import com.jomlx.widgets.TextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class Register extends javax.swing.JPanel {
    private String authCode = AuthCode.generateOTP();
    private TextField txtUsername;
    private TextField txtEmail;
    private PasswordField txtPassword;
    private PasswordField txtCPassword;
    private MyButton btnRegister;

    public Register() {
        initComponents();
        initRegister();
    }
    
    public void initRegister() {
        setLayout(new MigLayout("wrap, align center", "[center]", "push[]25[]5[]5[]1[]30[]push"));
        JLabel lblTitle = new JLabel("Sign Up");
        lblTitle.setFont(new Font("Sans Serif", 1, 35));
        lblTitle.setForeground(new Color(250, 250, 250));
        add(lblTitle);
        
        txtUsername = new TextField();
        txtUsername.setHint("USERNAME");
        txtUsername.setFont(new Font("Sans Serif", 1, 11));
        txtUsername.setBackground(new Color(30,33,36));
        txtUsername.setForeground(new Color(255, 255, 255));
        add(txtUsername, "width 72%, height 9%");
        
        txtEmail = new TextField();
        txtEmail.setHint("EMAIL");
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
        showPassword.setForeground(new Color(26,111,255));
        showPassword.setBackground(new Color(54,57,62));
        //showPassword.setFocusPainted(false);
        showPassword.setOpaque(false);
        //showPassword.setBorderPainted(false);
        showPassword.setContentAreaFilled(false);
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    txtPassword.setEchoChar((char) 0); // Show password
                    txtCPassword.setEchoChar((char) 0);
                } else {
                    txtPassword.setEchoChar('•'); // Hide password
                    txtCPassword.setEchoChar('•');
                }
            }
        });
        add(showPassword, "align left");
        
        txtCPassword = new PasswordField();
        txtCPassword.setHint("CONFIRM PASSWORD");
        txtCPassword.setFont(new Font("Sans Serif", 1, 11));
        txtCPassword.setBackground(new Color(30,33,36));
        txtCPassword.setForeground(new Color(255, 255, 255));
        add(txtCPassword, "width 72%, height 9%");
        
        btnRegister = new MyButton("Register");
        btnRegister.setFont(new Font("gg Sans", 1, 11));
        btnRegister.setBackground(new Color(123,100,241));
        btnRegister.setForeground(new Color(255, 255, 255));
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                char[] hashedPassword = txtPassword.getPassword();
                String password = Hash.hashPassword(hashedPassword);
                char[] confirmPassword = txtCPassword.getPassword();
                String password2 = Hash.hashPassword(confirmPassword);
                
                if (fieldRequired(txtUsername, txtEmail, txtPassword, txtCPassword)) {
                    
                    if (verify(email, password, password2)) {
                        MailService mail = new MailService(); // Email Sender
                        mail.sendMail(txtEmail.getText(), authCode);
                        txtUsername.setText("");
                        txtEmail.setText("");
                        txtPassword.setText("");
                        txtCPassword.setText("");
                        
                        OTPDialog OTPFrame = new OTPDialog(null, "Authentication");
                        OTPFrame.setVisible(true);
                        String emailCode = OTPFrame.getCode();
                        if (authCode.equals(emailCode)) {
                            
                        }
                    } else {
                        System.out.println("ERROR! occured during verification");
                    }
                    
                   
                }
            }
            
        });
        add(btnRegister, "width 70%");
    }
    // For verification of account
    public boolean verify(String email, String password, String confirmPassword) {
        if (!UserValidator.verifyRegister(email, password, confirmPassword)) {
            return false;
        }
        return true;
    }
    
    // For field requirement
    public static boolean fieldRequired(JTextField username, JTextField email, JPasswordField password, JPasswordField confirmPassword) {
        if (FieldValidator.isFieldEmpty(username)) {
            FieldValidator.showMessage("username");
            return false;
        }
        if (FieldValidator.isFieldEmpty(email)) {
            FieldValidator.showMessage("email");
            return false;
        }
        if (FieldValidator.isFieldEmpty(password)) {
            FieldValidator.showMessage("password");
            return false;
        }
        if (FieldValidator.isFieldEmpty(confirmPassword)) {
            FieldValidator.showMessage("confirm password");
            return false;
        }
        return true;
    }
    
    public String getAuthCode() {
        return authCode;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
