package com.jomlx.service;

import com.jomlx.components.ErrorDialog;
import com.jomlx.memo.Main;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FieldValidator {
    public static boolean isFieldEmpty(JTextField textField) {
        return textField.getText().trim().isBlank();
    }
    
    public static boolean isFieldEmpty(JPasswordField textField) {
        return textField.getPassword().length == 0;
    }
    
    public static void showMessage(String fieldName) {
        String title = "Error Found!";
        String errorMessage = "The " + fieldName + " field is required.";
        Main frame = Main.getFrame();
        ErrorDialog error = new ErrorDialog(frame, title, errorMessage);
        error.setVisible(true);
        /*
        ErrorDialog error = new ErrorDialog(null, title, errorMessage);
        error.setVisible(true);
        */
    }
}
