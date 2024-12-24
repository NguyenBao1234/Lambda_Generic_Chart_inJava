package ChartPractice;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;


public class PieChart extends ApplicationFrame
{
    public PieChart(String title)
    {
        super(title);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone", 40);
        dataset.setValue("SamSung", 30);
        dataset.setValue("Oppo", 20);
        dataset.setValue("Xiaomi", 10);

        JFreeChart chart = ChartFactory.createPieChart("Mobile Sales",dataset,true,true,false);
        setContentPane(new ChartPanel(chart));
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        PieChart demo = new PieChart("SimplePieChart");
    }
}