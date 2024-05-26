package com.jomlx.components;

import com.jomlx.widgets.MyButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ErrorDialog extends JDialog {
    private MigLayout layout;
    public ErrorDialog(Frame owner, String title, String errorMessage) {
        super(owner, title, true);
        showMessage(errorMessage);
        setSize(300, 200);
        setLocationRelativeTo(owner);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
    }
    
    public void showMessage(String errorMessage) {
        JPanel panel = new JPanel();
        layout = new MigLayout("wrap, align center", "[grow, center]", "push[]push");
        panel.setLayout(layout);
        panel.setBackground(new Color(40, 43, 48));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/jomlx/icon/warning.png"));
        Image resizeIcon =icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);Image resizedIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lblIcon = new JLabel(new ImageIcon(resizedIcon));
        panel.add(lblIcon);
        
        JLabel lblErrorMessage = new JLabel();
        lblErrorMessage.setText(errorMessage);
        lblErrorMessage.setForeground(new Color(255, 255, 255));
        panel.add(lblErrorMessage);
        
        MyButton btnContinue = new MyButton("Continue");
        btnContinue.setFont(new Font("gg Sans", 1, 11));
        btnContinue.setBackground(new Color(123,100,241));
        btnContinue.setForeground(new Color(255, 255, 255));
        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(btnContinue);
        
        setContentPane(panel);
    }
}
