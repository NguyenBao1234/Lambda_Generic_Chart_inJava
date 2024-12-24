package ChartPractice;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class PopulationPyramidChart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Population Chart Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(createChartPanel(), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JPanel createChartPanel() {
        // Tạo dataset cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Thêm dữ liệu (dương cho nữ, âm cho nam)
        dataset.addValue(-3, "Male", "70+");
        dataset.addValue(-5, "Male", "60-69");
        dataset.addValue(-8, "Male", "50-59");
        dataset.addValue(-10, "Male", "40-49");
        dataset.addValue(-12, "Male", "30-39");
        dataset.addValue(-15, "Male", "20-29");
        dataset.addValue(-18, "Male", "10-19");
        dataset.addValue(-20, "Male", "0-9");

        dataset.addValue(3, "Female", "70+");
        dataset.addValue(5, "Female", "60-69");
        dataset.addValue(8, "Female", "50-59");
        dataset.addValue(10, "Female", "40-49");
        dataset.addValue(12, "Female", "30-39");
        dataset.addValue(15, "Female", "20-29");
        dataset.addValue(18, "Female", "10-19");
        dataset.addValue(20, "Female", "0-9");


        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createBarChart(
                "Population Chart Demo",
                "Age Group",
                "Population (millions)",
                dataset,
                org.jfree.chart.plot.PlotOrientation.HORIZONTAL,
                true,
                true,
                false
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangeGridlinePaint(Color.GRAY);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(-25, 25); // Đặt khoảng giá trị âm và dương
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);

        // Tuỳ chỉnh trục phân loại (nhóm tuổi)
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(.001);

        return new ChartPanel(chart);
    }
}