package com.jomlx.user;

import com.jomlx.components.ErrorDialog;
import com.jomlx.database.User;
import com.jomlx.memo.Main;
import com.sanctionco.jmail.JMail;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,20}$";
    private static final String PASSWORD_PATTERN = ".{8,}";
    
    public UserValidator() {  } // default constructor
    
    public static boolean isValidUsername(String username) {
        if (!User.selectUserByUsername(username)) {
            return false;
        }
        return true;
    }
    public static boolean isValidUserName(String username) {
        return Pattern.compile(USERNAME_PATTERN).matcher(username).matches();
    }
    
    public static boolean isValidEmail(String email) {
        return JMail.strictValidator().isValid(email);
        
    }
    
    public static boolean isValidPassword(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }
    
    public static boolean verifyRegister(String username, String email, String password, String confirmPassword) {
        if (User.selectUserByUsername(username)) {
            String title = "Error Found!";
            String errorMessage = "Username was already taken..";
            
            Main frame = Main.getFrame();
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            return false;
        }
        if (User.selectUserByEmail(email)) {
            String title = "Error Found!";
            String errorMessage = "Email was already used.";
            
            Main frame = Main.getFrame();             
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            return false;
        }
        if (!password.equals(confirmPassword)) {
            String title = "Error Found!";
            String errorMessage = "Password mismatch.";
            
            Main frame = Main.getFrame();             
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            return false;
        }
        return true;
    }
    
    public static boolean verifyLogin(String email, String password) {
        if (!User.selectUserByUsernameAndEmail(email, email)) {
            String title = "Error Found!";
            String errorMessage = "invalid email or username.";
            
            Main frame = Main.getFrame();             
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            System.out.println(email);
            return false;
        }
        
        if (!User.selectUserByPassword(password)) {
            String title = "Error Found!";
            String errorMessage = "Wrong password.";
            
            Main frame = Main.getFrame();     
            ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
            error.setVisible(true);
            return false;
        }
        return true;
    }
}
