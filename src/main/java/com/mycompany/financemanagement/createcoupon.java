/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.financemanagement;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author manas
 */
public class createcoupon extends javax.swing.JFrame {

    String user;
    int bal,num=1;
    String msg;
    String line2;
    /**
     * Creates new form createcoupon
     @Override
     */
    public createcoupon(String user,int balance,String line) throws IOException {
        bal = balance;
        this.line2 = line;
        this.user = user;
        initComponents();
        takeqrno();
        path = Integer.toString(num)+".png";
        
    }
    
    private String path;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("GENERATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("MESSAGE:");

        jLabel2.setText("AMOUNT:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(442, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton1)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int amount;
        try{
        amount = Integer.parseInt(jTextField1.getText()); 
        }
        catch(NumberFormatException r){
            JOptionPane.showMessageDialog(null,"Enter a valid amount","title",JOptionPane.WARNING_MESSAGE);
            jTextField1.setText("");
            return;
        }
        
        msg = jTextField2.getText();
        
        if(amount>bal || amount<-1){
           JOptionPane.showMessageDialog(null,"Insufficient Balance","title",JOptionPane.WARNING_MESSAGE);
           jTextField1.setText("");
        }
        else{
        
        try {
            
            bal = bal - amount;
            FileWriter writer2 = new FileWriter("users\\"+user+"transactions.csv",true);
            LocalDateTime timenow = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = timenow.format(myFormatObj);
            String[] arrOfStr = formattedDate.split(" ", 2);
            writer2.write(arrOfStr[0]+","+arrOfStr[1]+","+amount+",1,"+bal+",giftcard\n");
            writer2.close();
            
            writer2 = new FileWriter("users\\"+user+"expense.csv",true);
            timenow = LocalDateTime.now();
            myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            formattedDate = timenow.format(myFormatObj);
            arrOfStr = formattedDate.split(" ", 2);
            writer2.write(arrOfStr[0]+","+arrOfStr[1]+","+amount+",GIFT\n");
            writer2.close();
            
            try {
                generateqr(Integer.toString(amount)+","+Integer.toString(num)+","+msg,600,600,path);
            } catch (WriterException ex) {
                Logger.getLogger(createcoupon.class.getName()).log(Level.SEVERE, null, ex);
            }
            writer2 = new FileWriter("coupons.txt",true);
            timenow = LocalDateTime.now();
            myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            formattedDate = timenow.format(myFormatObj);
            arrOfStr = formattedDate.split(" ", 2);
            writer2.write(arrOfStr[0]+","+arrOfStr[1]+","+num+","+amount+",0\n");
            writer2.close();

            
            
            JOptionPane.showMessageDialog(null,"Coupon is generated in "+path,"title",JOptionPane.WARNING_MESSAGE);
            new mainpage(line2).setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(createcoupon.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
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
            java.util.logging.Logger.getLogger(createcoupon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createcoupon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createcoupon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createcoupon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new createcoupon("dcs",12,"jcb ds").setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(createcoupon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public static void generateqr(String text,int width,int height,String path) throws WriterException{
        QRCodeWriter qc = new QRCodeWriter();
        BitMatrix bm = qc.encode(text, BarcodeFormat.QR_CODE, width, height);
        
        Path pobj = FileSystems.getDefault().getPath(path);
        
        try {
            MatrixToImageWriter.writeToPath(bm, "PNG", pobj);
        } catch (IOException ex) {
            Logger.getLogger(createcoupon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void takeqrno() throws FileNotFoundException, IOException{
        String line;
        FileReader reader = new FileReader("coupons.txt");
        BufferedReader bufread;
        bufread = new BufferedReader(reader);
        
        while((line = bufread.readLine())!=null){
            num++;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}