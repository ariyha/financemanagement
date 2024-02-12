/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.financemanagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sreeshanth
 */
public class addsavings extends javax.swing.JFrame {

    String outline;
    int balance;
    int amount;
    /**
     * Creates new form addsavings
     */
    public addsavings(String line,int bal) {
        outline = line;
        balance=bal;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AMOUNT:");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(459, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(44, 44, 44)))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       try{
            amount =  Integer.parseInt(jTextField1.getText());
            if(amount>balance || amount<=-1){
                JOptionPane.showMessageDialog(null,"Insufficient balance","title",JOptionPane.WARNING_MESSAGE);
            }
            else{
                if(balance<100){
                    if(JOptionPane.showConfirmDialog(null, "Ypu have a low balance are you sure to add?", "title", WIDTH)==0){
                        writedatain();
                        writedataout();
                        new mainpage(outline).setVisible(true);
                        JOptionPane.showMessageDialog(null,"Amount added to savings","title",JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                    else{
                        new mainpage(outline).setVisible(true);
                        this.dispose();                                
                    }
                }
                else{
                    writedatain();
                    writedataout();
                    JOptionPane.showMessageDialog(null,"Amount added to savings","title",JOptionPane.INFORMATION_MESSAGE);
                    new mainpage(outline).setVisible(true);
                    this.dispose();

                }
            }
       }
       catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null,"Enter a valid amount","title",JOptionPane.WARNING_MESSAGE);
       } catch (IOException ex) {
            Logger.getLogger(addsavings.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(addsavings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addsavings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addsavings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addsavings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addsavings("gbhjdcs",10).setVisible(true);
            }
        });
    }
    
    public void writedatain() throws FileNotFoundException, IOException{
        String mailid = outline.split(",")[1];
        balance = balance - amount;
        FileWriter writer2 = new FileWriter("users\\"+mailid+"transactions.csv",true);
        LocalDateTime timenow = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = timenow.format(myFormatObj);
        String[] arrOfStr = formattedDate.split(" ", 2);
        writer2.write(arrOfStr[0]+","+arrOfStr[1]+","+amount+",1,"+balance+",savings\n");
        writer2.close();
        
        writer2 = new FileWriter("users\\"+mailid+"expense.csv",true);
        timenow = LocalDateTime.now();
        myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate = timenow.format(myFormatObj);
        arrOfStr = formattedDate.split(" ", 2);
        writer2.write(arrOfStr[0]+","+arrOfStr[1]+","+amount+",SAVINGS\n");
        writer2.close();

    }
    
    public void writedataout(){
        FileReader reader = null;
        try {
            int balance2 = 0;
            reader = new FileReader("users//"+outline.split(",")[1]+"savings.csv");
            BufferedReader bufread;
            bufread = new BufferedReader(reader);
            bufread.readLine();
            String line2;
            while((line2 = bufread.readLine())!=null){
                balance2 = Integer.parseInt(line2.split(",")[4]);
                System.out.println(balance2);
            }   
            balance2 = balance2 + amount;
            FileWriter writer2 = new FileWriter("users//"+outline.split(",")[1]+"savings.csv",true);
            LocalDateTime timenow = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = timenow.format(myFormatObj);
            String[] arrOfStr = formattedDate.split(" ", 2);
            writer2.write(arrOfStr[0]+","+arrOfStr[1]+","+amount+",0,"+balance2+"\n");
            writer2.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(addsavings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addsavings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(addsavings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}