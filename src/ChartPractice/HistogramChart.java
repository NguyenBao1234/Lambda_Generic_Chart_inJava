package ChartPractice;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HistogramChart extends JFrame
{
    public HistogramChart()
    {
        setTitle("Histogram Chart Example");

        double[] data1 = generateRandomData(0,5); // must be double for DataSet
        double[] data2 = generateRandomData(4,10);

        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("So < 5", data1, 20);
        dataset.addSeries("So > 4", data2, 20);

        JFreeChart histogram = ChartFactory.createHistogram("Bieu Do Tan Suat","Value","Frequency",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYBarRenderer renderer = (XYBarRenderer) histogram.getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 0, 0, 120));
        renderer.setSeriesPaint(1, new Color(0, 0, 255, 120));

        setContentPane(new ChartPanel(histogram));
        pack();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private double[] generateRandomData(int min, int max)
    {
        Random random = new Random();
        double[] data = new double[100];
        for (int i = 0; i < data.length; i++) data[i] = min + random.nextFloat(max - min + 1);
        return data;
    }

    public static void main(String[] args)
    {
            new HistogramChart();
    }
}