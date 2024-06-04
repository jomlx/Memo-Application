package com.jomlx.components;

import com.jomlx.memo.Main;
import com.jomlx.widgets.MyButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ErrorDialog extends JDialog {
    private MigLayout layout;
    private JComponent glassPane;

    public ErrorDialog(JFrame owner, String title, String errorMessage) { 
        super(owner, true);
        setSize(250, 200);
        init(owner, title, errorMessage);
        setLocationRelativeTo(owner);
        setResizable(false);
        setUndecorated(true);
        ((Main) owner).showGlassPane(true);
    }

    public void init(JFrame owner, String title, String errorMessage) {
        JPanel panel = new JPanel();
        layout = new MigLayout(
            "wrap 1, align center, insets 2 2 2 2",
            "[grow, center][]",
            "[][]10[]15[]15[]"
        );
        panel.setLayout(layout);
        panel.setBackground(new Color(54, 57, 62));

        // Exit Icon
        ImageIcon exitIcon = new ImageIcon(getClass().getResource("/com/jomlx/icon/close-window.png"));
        Image resizeExitIcon = exitIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel lblExit = new JLabel(new ImageIcon(resizeExitIcon));
        lblExit.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(lblExit, "cell 1 0, align right");

        // Warning Icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/jomlx/icon/warning.png"));
        Image resizeWarningIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lblIcon = new JLabel(new ImageIcon(resizeWarningIcon));
        panel.add(lblIcon, "cell 0 1 2 1, align center");

        // Title
        JLabel lblTitle = new JLabel(title);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Sans Serif", 1, 12));
        panel.add(lblTitle, "cell 0 2 2 1, align center");

        // ErrorDialog Message
        JLabel lblMessage = new JLabel("<html><div style='text-align: center;'>" + errorMessage + "</div></html>");
        lblMessage.setForeground(Color.WHITE);
        lblMessage.setFont(new Font("Sans Serif", 0, 11));
        panel.add(lblMessage, "cell 0 3 2 1, align center");

        // Continue Button
        MyButton btnContinue = new MyButton();
        btnContinue.setText("Continue");
        btnContinue.setDefaultColor(new Color(11, 96, 176));
        btnContinue.setLighterColor(new Color(14, 122, 224));
        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Main) owner).showGlassPane(false);
                dispose();
            }
        });
        panel.add(btnContinue, "cell 0 4 2 1, align center");

        add(panel);
    }
    
}
