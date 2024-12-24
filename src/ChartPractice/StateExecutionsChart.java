package ChartPractice;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class StateExecutionsChart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("State Executions - USA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(createChartPanel(), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JPanel createChartPanel()
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(5, "Executions", "1975");
        dataset.addValue(10, "Executions", "1980");
        dataset.addValue(15, "Executions", "1985");
        dataset.addValue(20, "Executions", "1990");
        dataset.addValue(30, "Executions", "1995");
        dataset.addValue(50, "Executions", "2000");
        dataset.addValue(80, "Executions", "2005");
        dataset.addValue(90, "Executions", "2010");

        JFreeChart chart = ChartFactory.createBarChart(
                "State Executions - USA",
                "Year",
                "Number of People",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        //tao cho sub title
        TextTitle source = new TextTitle(
                "Source: http://www.amnestyusa.org/abolish/listbyyear.do",
                new Font("SansSerif", Font.PLAIN, 10)
        );
        chart.addSubtitle(source);

        // chinh mau
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setBackgroundPaint(Color.LIGHT_GRAY);

        return new ChartPanel(chart);
    }
}