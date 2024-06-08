package com.jomlx.components;

import com.jomlx.memo.Home;
import com.jomlx.memo.Main;

public class Settings extends javax.swing.JPanel {

    public Settings() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton1 = new com.jomlx.widgets.MyButton();

        setBackground(new java.awt.Color(30, 33, 36));
        setPreferredSize(new java.awt.Dimension(30, 350));

        myButton1.setBackground(new java.awt.Color(30, 33, 36));
        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jomlx/icon/sign-out.png"))); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.setVisible(false);
        new Home().setVisible(false);
        Home.getFrame().setVisible(false);
        Home.getFrame().dispose();
        //this.dispose();
    }//GEN-LAST:event_myButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jomlx.widgets.MyButton myButton1;
    // End of variables declaration//GEN-END:variables
}
