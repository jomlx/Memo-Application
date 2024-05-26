package com.jomlx.components;

import com.jomlx.memo.Register;
import com.jomlx.widgets.MyButton;
import com.jomlx.widgets.TextField;
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

public class OTPDialog extends JDialog {
    private MigLayout layout;
    private TextField txtAuthCode;
    private String code;

    public OTPDialog() {}

    public OTPDialog(Frame owner, String title) {
        super(owner, title, true);
        init();
        setSize(350, 300);
        setLocationRelativeTo(owner);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public void init() {
        JPanel panel = new JPanel();
        layout = new MigLayout("wrap 1, align center, insets 20", "[center]", "push[]10[]10[]10[]10[]push");
        panel.setLayout(layout);
        panel.setBackground(new Color(40, 43, 48));

        ImageIcon icon = new ImageIcon(getClass().getResource("/com/jomlx/icon/auth-code.png"));
        Image resizedIcon = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel lblIcon = new JLabel(new ImageIcon(resizedIcon));
        panel.add(lblIcon, "align center");

        JLabel lblTitle = new JLabel("Two-factor Authenticator");
        lblTitle.setFont(new Font("Sans Serif", 1, 15));
        lblTitle.setForeground(new Color(255, 255, 255));
        panel.add(lblTitle, "align center");

        JLabel lblDescription = new JLabel("<html><div style='text-align: center;'>We've sent a message to your email. Please enter the<br>code you received.</div></html>");
        lblDescription.setFont(new Font("Sans Serif", 0, 11));
        lblDescription.setForeground(new Color(255, 255, 255));
        panel.add(lblDescription, "align center");

        txtAuthCode = new TextField();
        txtAuthCode.setHint("6-Digit Authentication Code");
        txtAuthCode.setFont(new Font("Sans Serif", 1, 11));
        txtAuthCode.setForeground(new Color(255, 255, 255));
        txtAuthCode.setBackground(new Color(30, 33, 36));
        panel.add(txtAuthCode, "align center, width 50%, height 15%");

        MyButton btnContinue = new MyButton("Continue");
        btnContinue.setFont(new Font("gg Sans", 1, 15));
        btnContinue.setBackground(new Color(123, 100, 241));
        btnContinue.setForeground(new Color(255, 255, 255));
        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCode(txtAuthCode.getText());
                dispose();
                System.out.println("SUCCESSFULLY MATCH!");
                Register register = new Register();

                if (code.equals(register.getAuthCode())) {
                    System.out.println("SUCCESSFULLY MATCH");
                }
            }
        });
        panel.add(btnContinue, "align center");

        setContentPane(panel);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
