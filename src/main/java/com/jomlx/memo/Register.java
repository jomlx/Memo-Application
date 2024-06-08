package com.jomlx.memo;

import com.jomlx.components.LoadingScreen;
import com.jomlx.components.OTPVerification;
import com.jomlx.database.User;
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
import java.sql.Timestamp;
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
        setLayout(new MigLayout("wrap, align center", "[center]", "push[]25[]5[]5[]1[]15[]25[]push"));
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
        showPassword.setForeground(new Color(85,136,255));
        showPassword.setFocusPainted(false);
        showPassword.setOpaque(false);
        showPassword.setBorderPainted(false);
        showPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    // Show password
                    txtPassword.setEchoChar((char) 0);
                    txtCPassword.setEchoChar((char) 0);
                } else {
                    // Hide password
                    txtPassword.setEchoChar('•');
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
        
        btnRegister = new MyButton();
        btnRegister.setText("Register");
        btnRegister.setDefaultColor(new Color(11, 96, 176));
        btnRegister.setLighterColor(new Color(14, 122, 224));
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String email = txtEmail.getText();
                char[] hashedPassword = txtPassword.getPassword();
                String password = Hash.hashPassword(hashedPassword);
                char[] confirmPassword = txtCPassword.getPassword();
                String password2 = Hash.hashPassword(confirmPassword);
                Timestamp creationDate = new Timestamp(System.currentTimeMillis());               
                
                if (fieldRequired(txtUsername, txtEmail, txtPassword, txtCPassword)) {
                    
                    if (verify(username,email, password, password2)) {                       
                        MailService mail = new MailService();   // Create object for MailService
                        mail.sendMail(txtEmail.getText(), authCode);    // Sending OTP code to user's email
                        txtUsername.setText("");
                        txtEmail.setText("");
                        txtPassword.setText("");
                        txtCPassword.setText("");
                       
                        Main frame = Main.getFrame();
                        OTPVerification OTPVerify = new OTPVerification(frame, true);
                        OTPVerify.setVisible(true); // Make the OTPVerification visible to screen

                        String emailCode = OTPVerify.getOTPCode();
                        System.out.println(emailCode);
                        if (authCode.equals(emailCode)) {
                            User.addUser(username, email, password, creationDate);  // Added to database
                            frame.setVisible(false);
                            new LoadingScreen().setVisible(true);
                            frame.dispose();
                            
                            System.out.println("OTP match perfectly!");
                        }
                    } else {
                        System.out.println("ERROR! occured during verification.");
                    }
                    
                   
                }
            }
            
        });
        add(btnRegister, "width 70%");
    }
    // For verification of account
    public boolean verify(String username, String email, String password, String confirmPassword) {
        if (!UserValidator.verifyRegister(username, email, password, confirmPassword)) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
