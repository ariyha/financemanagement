/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.financemanagement;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author athee
 */
public class expense extends javax.swing.JFrame {

    int FOOD=0, TRAVEL=0, STATIONARIES=0, CLOTHING=0, MOBILE=0, MOVIES=0, GAMES=0, GIFT=0, LENDING=0, OTHERS=0;
    String outline;
    int noofexpense=-1;
    String table[][];
    String table2[][] = new String[10][2];
    /**
     * Creates new form expense
     */
    public expense(String line) throws IOException {
        outline = line;
        initComponents();
        count();
        buildtable();
        buildtable2();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(table, new String [] {"DATE","TIME","AMOUNT","TYPE"}));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(table2, new String [] {"CATEGORY","AMOUNT"}));
        addtext();
        jTable1.setEnabled(false);
        jTable2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SHOW CHART");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable2.setAlignmentY(1.0F);
        jScrollPane2.setViewportView(jTable2);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jButton2)
                .addGap(260, 260, 260)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            PieChartExample example = new PieChartExample(outline);
            example.setSize(700, 700);
            example.setLocationRelativeTo(null);  
            example.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            new mainpage(outline).setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(expense.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(expense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new expense("nithish,nithish,1234567890,qwert,0,tqdvgjash\n").setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(expense.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void count() throws IOException{
        ReversedLinesFileReader fr = new ReversedLinesFileReader(new File("users//"+outline.split(",")[1]+"expense.csv"));
        String line2;
        
        while((line2=fr.readLine())!=null){
            noofexpense++;
        }

    }
    
    public void addtext(){
        if(max()=="FOOD"){
            jTextArea1.setText("You might wanna start hitting\n the gym with some diet");
        }
        else if(max()=="CLOTHING"){
            jTextArea1.setText("We think your closet has\nenough styles and you can save\nsome money there");
        }
        else if(max()=="GAMES"){
            jTextArea1.setText("Your PC and console needs \nsome rest too coz they \ntoo have feelings");
            
        }
        else if(max()=="MOBILE"){
            jTextArea1.setText("Your mobile can have \nsome lower recharge amounts");
        }
        else if(max()=="LENDING"){
            jTextArea1.setText("We can undrstand your generous\nnature but save some for \nyourself too");
        }
        else if(max()=="MOVIES"){
            jTextArea1.setText("Movies can be watched \nin OTT platoforms and \nother ways too");
        }
        else if(max()=="STATIONARIES"){
            jTextArea1.setText("Yes, Studying is important but\nstationaries of some lower cost\ncan also be used in some cases");
        }
        else if(max()=="TRAVEL"){
            jTextArea1.setText("Staying at hostel can also be\nfun instead of some places");
        }
        else if(max()=="OTHERS"){
            jTextArea1.setText("You are spending one something\nthat must not be for a\nstudent so be careful");
        }
        else if(max()=="GIFT"){
            jTextArea1.setText("Gifting is a good habit but\nsave some for yourself too");
        }
    }
    
    public void buildtable() throws IOException{
        table = new String[noofexpense][4];
        ReversedLinesFileReader fr = new ReversedLinesFileReader(new File("users//"+outline.split(",")[1]+"expense.csv"));
        String line2;
        
        for(int i=0;i<noofexpense;i++){
           line2 = fr.readLine();
           String opt = line2.split(",")[3];
           int AMOUNT = Integer.parseInt(line2.split(",")[2]);

           switch(opt){
               case("FOOD"):
                   FOOD = FOOD+AMOUNT;
                   break;
                case("TRAVEL"):
                    TRAVEL = TRAVEL + AMOUNT;
                   break;
                case("STATIONARIES"):
                    STATIONARIES=STATIONARIES+AMOUNT;
                    break;
                case("CLOTHING"):
                    CLOTHING=CLOTHING+AMOUNT;
                    break;
                case("MOBILE"):
                    MOBILE=MOBILE+AMOUNT;
                    break;
                case("MOVIES"):
                    MOVIES=MOVIES+AMOUNT;
                    break;
                case("GAMES"):
                    GAMES=GAMES+AMOUNT;
                    break;
                case("GIFT"):
                    GIFT=GIFT+AMOUNT;
                    break;
                case("LENDING"):
                    LENDING=LENDING+AMOUNT;
                    break;
                default:
                    OTHERS=OTHERS+AMOUNT;
                    break;
                    
           }
            
            for(int j=0;j<4;j++){
               table[i][j]=line2.split(",")[j];
            }
        }

    }
    
    public void buildtable2(){
        table2[0][0]="FOOD";
        table2[1][0]="TRAVEL";
        table2[2][0]="STATIONARIES";
        table2[3][0]="CLOTHING";
        table2[4][0]="MOBILE";
        table2[5][0]="MOVIES";
        table2[6][0]="GAMES";
        table2[7][0]="GIFT";
        table2[8][0]="LENDING";
        table2[9][0]="OTHERS";
        
        table2[0][1]=Integer.toString(FOOD);
        table2[1][1]=Integer.toString(TRAVEL);
        table2[2][1]=Integer.toString(STATIONARIES);
        table2[3][1]=Integer.toString(CLOTHING);
        table2[4][1]=Integer.toString(MOBILE);
        table2[5][1]=Integer.toString(MOVIES);
        table2[6][1]=Integer.toString(GAMES);
        table2[7][1]=Integer.toString(GIFT);
        table2[8][1]=Integer.toString(LENDING);
        table2[9][1]=Integer.toString(OTHERS);
    }
    
    public String max(){
        int a[] = new int[10];
        String b[] = new String[10];
        
        
        int max=0;
        a[0]=FOOD;
        a[1]=TRAVEL;
        a[2]=STATIONARIES;
        a[3]=CLOTHING;
        a[4]=MOBILE;
        a[5]=MOVIES;
        a[6]=GAMES;
        a[7]=GIFT;
        a[8]=LENDING;
        a[9]=OTHERS;
        
        b[0]="FOOD";
        b[1]="TRAVEL";
        b[2]="STATIONARIES";
        b[3]="CLOTHING";
        b[4]="MOBILE";
        b[5]="MOVIES";
        b[6]="GAMES";
        b[7]="GIFT";
        b[8]="LENDING";
        b[9]="OTHERS";

        for(int i=1;i<10;i++){
            if(a[i]>a[max]){
                max = i;
            }
        }
        
        return b[max];

    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}