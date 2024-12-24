package ChartPractice;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart extends JFrame
{
    public BarChart()
    {
        setTitle("Bar Chart Window");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(10, "USA", "2005");
        dataset.addValue(15, "India", "2005");
        dataset.addValue(20, "China", "2005");

        dataset.addValue(15, "USA", "2010");
        dataset.addValue(20, "India", "2010");
        dataset.addValue(25, "China", "2010");

        JFreeChart chart=ChartFactory.createBarChart("Bar Chart Example", "Year","Population in Million", dataset,
                PlotOrientation.VERTICAL,
                true,true,false);

        setContentPane(new ChartPanel(chart));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args)
    {
        new BarChart();
    }
}
