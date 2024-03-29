/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.mycompany.multichat;
package clientapplication;

import java.awt.Color;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.EventQueue.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.*;
/**
 *
 * @author yabok
 */
public class chat extends JFrame {

    static chat instance = null;
    Thread thread;
    SimpleAttributeSet another = new SimpleAttributeSet();
    SimpleAttributeSet me = new SimpleAttributeSet();
    StyledDocument doc = null;
    public static chat getInstance()
    {
        if (instance == null)
            return instance = new chat();
        return instance;
    }
    /**
     * Creates new form chat
     */
    public chat() {        
        StyleConstants.setAlignment(another, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(another, Color.BLACK);
        
        StyleConstants.setAlignment(me, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(me, Color.BLUE);
        initComponents();
        setLocationRelativeTo(this);
        doc = displayChatPanel.getStyledDocument();
        nametxt.setText(clientThread.getInstance().getNameSV());
        mssvtxt.setText(clientThread.getInstance().getMssvSV().trim().toUpperCase());
        macode.setText(clientThread.getInstance().getCodeRoom().toString());
        thread = new Thread(new Runnable() {
            @Override
            public void run() 
            {                                
                while (true)
                {
                    try {
                        if (clientThread.getInstance().getSocket() != null)
                        {
                            String msg = "";
                            msg = clientThread.getInstance().getDin().readUTF().trim();
                            if (!msg.equals("")) {
                                doc.insertString(doc.getLength(),msg +"\n" , another);
                                doc.setParagraphAttributes(doc.getLength(), 1, another, false);
                            }
                            
                        }
                    } catch (BadLocationException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Error" , JOptionPane.ERROR_MESSAGE);
                        break;
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Error" , JOptionPane.ERROR_MESSAGE);                        
                        break;
                    }
                }
            }
        }); 
        thread.start();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        chatF = new javax.swing.JTextArea();
        SENDbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nametxt = new javax.swing.JLabel();
        mssvtxt = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        displayChatPanel = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        macode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        chatF.setColumns(20);
        chatF.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        chatF.setRows(5);
        chatF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chatFKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(chatF);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(150, 620, 390, 133);

        SENDbutton.setBackground(new java.awt.Color(0, 145, 255));
        SENDbutton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        SENDbutton.setForeground(new java.awt.Color(255, 255, 255));
        SENDbutton.setText("Gửi");
        SENDbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SENDbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(SENDbutton);
        SENDbutton.setBounds(650, 630, 191, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhập nội dung:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 570, 390, 22);

        jLabel2.setBackground(new java.awt.Color(102, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Trang chính");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 30, 640, 29);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 1, 1, 1, new java.awt.Color(0, 145, 255)));
        jPanel1.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Thông tin cá nhân");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Họ và tên:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("MSSV:");

        nametxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nametxt.setText("name");

        mssvtxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mssvtxt.setText("mssv");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mssvtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mssvtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(293, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(680, 80, 230, 470);
        jPanel1.getAccessibleContext().setAccessibleParent(jScrollPane2);

        displayChatPanel.setEditable(false);
        displayChatPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 1, 1, 1, new java.awt.Color(0, 204, 255)));
        jScrollPane3.setViewportView(displayChatPanel);
        DefaultCaret caret = (DefaultCaret)displayChatPanel.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 80, 650, 470);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(650, 700, 191, 50);

        macode.setEditable(false);
        macode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        macode.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(0, 204, 255)));
        macode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(macode);
        macode.setBounds(750, 10, 140, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("CODE :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(680, 12, 70, 50);

        setSize(new java.awt.Dimension(936, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SENDbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SENDbuttonActionPerformed
        // TODO add your handling code here:
        String msg = chatF.getText();
        if (msg.isEmpty()) return;
        //Pattern pattern = Pattern.compile("\\d*"); //"^[1-9]|10$"
        Pattern pattern = Pattern.compile("^[1-9]|10$");
        Matcher matcher = pattern.matcher(msg);
        if (!matcher.matches()) {
          JOptionPane.showMessageDialog(this, "Chuỗi không hợp lệ " + "\n"+ " Vui Lòng Nhập số");
        return;
        }
        try {
            
            clientThread.getInstance().getDout().writeUTF(msg);         
            chatF.setText("");
            String[] strTemps = msg.split("\n");
            if (strTemps.length == 0) return;
            if (!strTemps[0].trim().equals(""))
            {
                doc.insertString(doc.getLength(),"Tôi: " + strTemps[0] + "\n" , me);
                doc.setParagraphAttributes(doc.getLength(), 1, me, false);
            }
            else
            {
                doc.insertString(doc.getLength(),"Tôi:" , me);
                doc.setParagraphAttributes(doc.getLength(), 1, me, false);
            }
            if (strTemps.length > 1)
                for (int i =1; i< strTemps.length; i++)
                {
                    if (strTemps[i].trim().equals("")) continue;
                    doc.insertString(doc.getLength()," " + strTemps[i] + "\n" , me);
                    doc.setParagraphAttributes(doc.getLength(), 1, me, false);
                }
            
                      
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" , JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(chat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error" , JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(chat.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_SENDbuttonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            thread.stop();
            clientThread.getInstance().getSocket().close();            
        } catch (IOException ex) {
            Logger.getLogger(chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void chatFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chatFKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_chatFKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:  
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SENDbutton;
    private javax.swing.JTextArea chatF;
    private javax.swing.JTextPane displayChatPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField macode;
    private javax.swing.JLabel mssvtxt;
    private javax.swing.JLabel nametxt;
    // End of variables declaration//GEN-END:variables
}
