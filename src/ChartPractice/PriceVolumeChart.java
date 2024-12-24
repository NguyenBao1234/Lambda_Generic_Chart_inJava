package ChartPractice;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PriceVolumeChart extends JFrame
{
    private PriceVolumeChart ()
    {
        NumberAxis priceAxis = new NumberAxis("Price");
        priceAxis.setRange(94,99);

        StandardXYItemRenderer priceRenderer = new StandardXYItemRenderer();
        priceRenderer.setSeriesPaint(0, Color.RED);

        TimeSeriesCollection priceDataset = createMassiveData(95, -.25f,.25f, true); //Su dung data chua time
        XYPlot plot = new XYPlot(priceDataset, null, priceAxis, priceRenderer);


        NumberAxis volumeAxis = new NumberAxis("Volume");
        volumeAxis.setTickUnit(new NumberTickUnit(100000));
        volumeAxis.setRange(0,700000);

        plot.setRangeAxis(1, volumeAxis);
        TimeSeriesCollection volumeDataset = createMassiveData(50000,10000,200000, false);
        plot.setDataset(1, volumeDataset);
        plot.mapDatasetToRangeAxis(1, 1);

        XYBarRenderer volumeRenderer = new XYBarRenderer();
        volumeRenderer.setSeriesPaint(0, new Color(0,0,200,100));
        plot.setRenderer(0, volumeRenderer);

        DateAxis dateAxis = new DateAxis("Date");
        dateAxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        plot.setDomainAxis(dateAxis);


        JFreeChart chart = new JFreeChart(
                "Eurodollar Futures Contract (MAR03)",
                JFreeChart.DEFAULT_TITLE_FONT,
                plot,
                true
        );

        add(new ChartPanel(chart));
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static TimeSeriesCollection createMassiveData(float value, float offsetMin,float offsetMax, boolean bRecursive )
    {
        TimeSeries TimeSeries = new TimeSeries("Volume");
        Random random = new Random();
        float valueOfKey = value;
        for(int j = 1; j < 13; j++)
        {
            for (int i = 1; i <= 28; i++)
            {
                float amountChange = random.nextFloat(offsetMin,offsetMax);
                valueOfKey = bRecursive? (valueOfKey + amountChange): (value + amountChange);
                TimeSeries.add(new Day(i, j, 2024), valueOfKey);
            }
        }
        return new TimeSeriesCollection(TimeSeries);
    }

    public static void main(String[] args)
    {
        new PriceVolumeChart();
    }
}
