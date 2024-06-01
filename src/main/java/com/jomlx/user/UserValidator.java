package com.jomlx.user;

import com.jomlx.components.ErrorDialog;
import com.jomlx.memo.Main;
import com.sanctionco.jmail.JMail;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class UserValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,20}$";
    private static final String PASSWORD_PATTERN = ".{8,}";
    
    public UserValidator() {  } // default constructor
    
    public static boolean isValidUsername(String username) {
        return Pattern.compile(USERNAME_PATTERN).matcher(username).matches();
    }
    
    public static boolean isValidEmail(String email) {
        return JMail.strictValidator().isValid(email);
        
    }
    
    public static boolean isValidPassword(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }
    
    public static boolean confirmation(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }
    
    public static boolean verifyRegister(String email, String password, String confirmPassword) {
        if (!isValidEmail(email)) {
            String title = "Error Found!";
            String errorMessage = "Please enter a valid email address.";
            
            Main frame = Main.getMainFrame();             
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            return false;
        }
        if (!isValidPassword(password)) {
            String title = "Wrong Password!";
            String errorMessage = "Please check your password.";
            
            Main frame = Main.getMainFrame();             
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            return false;
        }
        if (!password.equals(confirmPassword)) {
            String title = "Error Found!";
            String errorMessage = "Password mismatch.";
            
            Main frame = Main.getMainFrame();             
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            
            return false;
        }
        return true;
    }
}
