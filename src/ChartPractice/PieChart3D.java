package ChartPractice;


import javax.swing.JFrame;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;


public class PieChart3D extends JFrame
{
    public PieChart3D()
    {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Linux", 29);
        dataset.setValue("Mac", 20);
        dataset.setValue("Windows", 51);

        JFreeChart chart = ChartFactory.createPieChart3D("OS Chart",dataset,true,true,false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        setContentPane(new ChartPanel(chart));

        pack();
        setVisible(true);
        setDefaultCloseOperation(3);
    }


    public static void main(String[] args)
    {
        new PieChart3D();
    }
}




