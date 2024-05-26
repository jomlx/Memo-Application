package com.jomlx.user;

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
            JOptionPane.showMessageDialog(null,
            "The " + email + " address you entered is not valid. Please enter a valid email address.",
            "Required Field",
            JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!isValidPassword(password)) {
            JOptionPane.showMessageDialog(null,
            "The " + password + " you entered is not valid. Please enter a valid password.",
            "Required Field",
            JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null,
            "Confirm Password must match the Password field.",
            "Password Mismatch",
            JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
