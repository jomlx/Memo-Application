package com.jomlx.memo;

import com.jomlx.components.PanelCover;
import com.jomlx.components.TitleBar;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {
    
    private static Main frame;
    private MigLayout layout;
    private PanelCover cover;
    private TitleBar titleBar;
    private Login login;
    private Register register;
    private final double addSize = 30;
    private final double coverSize = 50;
    private final double halfSize = 50;
    private boolean isLogin;
    private final DecimalFormat df = new DecimalFormat("##0.###");
    
    public Main() {
        frame = this;
        setTitle("Memo");
        initComponents();
        init();
    }
    
    public void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        titleBar = new TitleBar();
        login = new Login();
        register = new Register();
        
        login.setVisible(true);
        register.setVisible(false);
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double fractionRegister;
                double size = coverSize;
                
                if (fraction <= 0.5f) {
                    size += fraction* addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    fractionRegister = fraction;
                    
                    // For PanelCover transition
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100 );
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    fractionRegister = 1f - fraction;
                    
                    // For PanelCover transition
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100 );
                    }
                    
                }
                
                // for transition
                if (fraction >= 0.5f) {
                    if (isLogin) {
                        login.setVisible(true);
                        register.setVisible(false);
                    } else {
                        login.setVisible(false);
                        register.setVisible(true);
                    }
                }
                
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                fractionRegister = Double.valueOf(df.format(fractionRegister));
                layout.setComponentConstraints(cover, "width " + size + "%, pos" + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(login, "width " + halfSize + "%, pos" + fractionLogin + "al 0 n 100%");
                layout.setComponentConstraints(register, "width " + halfSize + "%, pos" + fractionRegister + "al 0 n 100%");
                bg.revalidate();
            }
            public void end() {
                isLogin =! isLogin;
            }
        };
        Animator animator = new Animator(1000, target);   
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // for smooth animation
        
        bg.setLayout(layout);
        bg.add(titleBar, "dock north, h 20!");
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(login, "width " + halfSize + "%, pos 1al 0 n 100%");
        bg.add(register, "width " + halfSize + "%, pos 1al 0 n 100%");
        
        
        cover.addEvent(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });        
    }
    
    public void showGlassPane(boolean show) {
        setGlassPane(new JComponent(){
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
        
        Container glassPane = (Container)getGlassPane();
        glassPane.setVisible(show);
    }
    
    public static Main getMainFrame() {
        return frame;
    }

    public static void setMainFrame(Main mainFrame) {
        frame = mainFrame;
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(47, 49, 54));
        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
