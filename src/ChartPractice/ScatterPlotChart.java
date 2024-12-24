package ChartPractice;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ScatterPlotChart extends JFrame {

    public ScatterPlotChart() {
        setTitle("Scatter Plot Example");

        XYSeries series1 = new XYSeries("Series 1");
        ChangeXYSeriesData(1, 50, series1);
        XYSeries series2 = new XYSeries("Series 2");
        ChangeXYSeriesData(-1, 50, series2);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "Scatter Plot Example",
                "X-Axis",
                "Y-Axis",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CustumFunction(scatterPlot);
        setContentPane(new ChartPanel(scatterPlot));
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void CustumFunction(JFreeChart ScatterPlotChart)
    {
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        ScatterPlotChart.getXYPlot().setRenderer(renderer);

        NumberAxis xAxis = (NumberAxis) ScatterPlotChart.getXYPlot().getDomainAxis();
        NumberAxis yAxis = (NumberAxis) ScatterPlotChart.getXYPlot().getRangeAxis();

        xAxis.setAutoRangeIncludesZero(true);
        yAxis.setAutoRangeIncludesZero(true);
    }
    private void ChangeXYSeriesData(int IndexF, int AmountValues, XYSeries TapGiaTri)
    {
        Random random = new Random();
        for (int i = 0 ; i <AmountValues; i++)
        {
            float y;
            if(IndexF > 0) y = i*i -2;
            else if(IndexF ==0) y = 5*i+3;
            else
            {
                float x = random.nextFloat(AmountValues/2);
                y = random.nextFloat(AmountValues/2);
                TapGiaTri.add(x,y); continue;
            }
            TapGiaTri.add(i,y);
        }
    }

    public static void main(String[] args)
    {
         new ScatterPlotChart();
    }
}
