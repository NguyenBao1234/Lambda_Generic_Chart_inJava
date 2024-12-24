package ChartPractice;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class LineChart extends JFrame
{
    public LineChart()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(200, "Luong Khach", "2016-12-19");
        dataset.addValue(150, "Luong Khach", "2016-12-20");

        dataset.addValue(150, "Khach Moi", "2016-12-19");
        dataset.addValue(170, "Khach Moi", "2016-12-20");

        JFreeChart chart = ChartFactory.createLineChart("Site Traffic","Date","Number of Visitor",dataset, PlotOrientation.VERTICAL,true,true,false);
        setContentPane(new ChartPanel(chart));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Line Chart Example");
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new LineChart();
    }
}
