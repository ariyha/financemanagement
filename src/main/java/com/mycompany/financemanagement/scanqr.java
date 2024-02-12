/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.financemanagement;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author manas
 */
public class scanqr extends JFrame implements Runnable{

    /**
     * Creates new form scanqr
     */
    
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = null;
    String outline;
    String qrline;
    String strarr[];
    String no,msg;
    int amount;
    public scanqr(String line) {
        outline=line;
        initComponents();
        initWebcam();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 370));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            webcam.close();
            new mainpage(outline).setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(scanqr.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(scanqr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scanqr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scanqr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scanqr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scanqr("cddccdcd").setVisible(true);
            }
        });
    }
    
 private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getDefault();
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        
        jPanel1.setLayout(new BorderLayout()); // Set the layout manager for jPanel2
        jPanel1.add(panel, BorderLayout.CENTER); // Add the panel to the center of jPanel2

        executor = Executors.newSingleThreadExecutor(); // Initialize the executor

        executor.execute((Runnable) this);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

public void run() {
        boolean b = true;

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
//               Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE,null,ex);
            }

            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }

            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {

            }
            if (result != null) {
                
                qrline = result.getText();
                strarr = qrline.split(",");
                no = strarr[1];
                msg = strarr[2];
                amount = Integer.parseInt(strarr[0]);
                try {
                    addmoney();
                } catch (IOException ex) {
                    Logger.getLogger(scanqr.class.getName()).log(Level.SEVERE, null, ex);
                }
                jLabel1.setText(result.getText());
            }

        } while (b);
    }

    public void addmoney() throws IOException{
        String line;
        String coupno;
        FileReader reader = null;
        try {
            reader = new FileReader("coupons.txt");
            BufferedReader bufread = new BufferedReader(reader);
            while((line=bufread.readLine())!=null){
                coupno = line.split(",")[2];
                System.out.println(coupno);
                if(coupno.equals(no)){
                    if(line.split(",")[4].equals("1")){
                        JOptionPane.showMessageDialog(null,"Coupon is already used","title",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        writedataout();
                        updatecoupon();
                        JOptionPane.showMessageDialog(null,msg,"title",JOptionPane.INFORMATION_MESSAGE);

                        
                    }
                    
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(scanqr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(scanqr.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             reader.close();
        }
    }
    public void writedataout() throws IOException{
        int balance = 0;
       
        FileReader reader = new FileReader("users//"+outline.split(",")[1]+"transactions.csv");
        BufferedReader bufread;
        bufread = new BufferedReader(reader);
        bufread.readLine();
        String line2;
        while((line2 = bufread.readLine())!=null){
            balance = Integer.parseInt(line2.split(",")[4]);
        }
        reader.close();
        
        balance = balance+amount;
        FileWriter writer2 = new FileWriter("users\\"+outline.split(",")[1]+"transactions.csv",true);
        LocalDateTime timenow = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = timenow.format(myFormatObj);
        String[] arrOfStr = formattedDate.split(" ", 2);
        writer2.write(arrOfStr[0]+","+arrOfStr[1]+","+amount+",0,"+balance+",giftcard\n");
        writer2.close();
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
    
    public void updatecoupon() throws FileNotFoundException, IOException{
        String line;
        
        FileWriter writer = new FileWriter("temp.txt");
        
        FileReader reader = new FileReader("coupons.txt");
        BufferedReader bufread = new BufferedReader(reader);
        
        while((line = bufread.readLine())!=null){
            if(line.split(",")[2].equals(no)){
                writer.write(line.split(",")[0]+","+line.split(",")[1]+","+line.split(",")[2]+","+line.split(",")[3]+",1\n");
            }
            else{
                
                writer.write(line+"\n");
            }
            
        }
        writer.close();
        reader.close();

        writer = new FileWriter("coupons.txt");
        
        reader = new FileReader("temp.txt");
        bufread = new BufferedReader(reader);

        
        
        while((line= bufread.readLine())!=null){
            writer.write(line+"\n");
        }
        
        writer.close();
        

    }
}