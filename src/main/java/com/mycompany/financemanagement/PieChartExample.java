package com.mycompany.financemanagement;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;  
import java.util.logging.Level;
import java.util.logging.Logger;
  
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;  
import org.apache.commons.io.input.ReversedLinesFileReader;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.PieSectionLabelGenerator;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.data.general.PieDataset;  
public class PieChartExample extends JFrame {  
    int FOOD=0, TRAVEL=0, STATIONARIES=0, CLOTHING=0, MOBILE=0, MOVIES=0, GAMES=0, GIFT=0, LENDING=0, OTHERS=0;
    String outline;
    int noofexpense=-1;
    String table[][];


  
  public PieChartExample(String line) {
      
          super("EXPENSE CHART");
          outline = line;

        try {
            count();
            buildtable();
            
                        
            PieDataset dataset = createDataset();
            
            // Create chart
            JFreeChart chart = ChartFactory.createPieChart(
                    "Expense",
                    dataset,
                    true,
                    true,
                    false);
            
            //Format Label
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                    "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
            
            // Create Panel            ChartPanel panel = new ChartPanel(chart);

            ChartPanel panel = new ChartPanel(chart);
            setContentPane(panel);  
        } catch (IOException ex) {
            Logger.getLogger(PieChartExample.class.getName()).log(Level.SEVERE, null, ex);
        }
  }  
  
    public PieDataset createDataset(){
        DefaultPieDataset dataset = new DefaultPieDataset( );
        dataset.setValue("FOOD", FOOD);
        dataset.setValue("TRAVEL", TRAVEL);
        dataset.setValue("STATIONARIES", STATIONARIES);
        dataset.setValue("CLOTHING", CLOTHING);
        dataset.setValue("MOBILE", MOBILE);
        dataset.setValue("MOVIES", MOVIES);
        dataset.setValue("GAMES", GAMES);
        dataset.setValue("GIFT", GIFT);
        dataset.setValue("LENDING", LENDING);
        dataset.setValue("OTHERS", OTHERS);
        return dataset;

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
      
    public void count() throws IOException{
        ReversedLinesFileReader fr = new ReversedLinesFileReader(new File("users//"+outline.split(",")[1]+"expense.csv"));
        String line2;
        
        while((line2=fr.readLine())!=null){
            noofexpense++;
        }

    }


  
  public static void main(String[] args) {  
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            PieChartExample example = new PieChartExample("nithish,nithish,1234567890,qwert,0,tqdvgjash\n" );
            example.setSize(700, 370);
            example.setLocationRelativeTo(null);  
            example.setVisible(true);
        }
    });  
  }  

}  