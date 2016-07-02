package ui;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraphicChart extends ApplicationFrame{
	
	private final XYSeries avgSeries, maxSeries;
	
	public GraphicChart(){
		super("SIA - TP3");
		avgSeries = new XYSeries("Average Fitness");
		maxSeries = new XYSeries("Maximum Fitness");
	}
	
	public void addAvgValue(double x, double y){
		avgSeries.add(x, y);
	}
	
	public void addMaxValue(double x, double y){
		maxSeries.add(x, y);
	}
	
	
	public void draw(){
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(avgSeries);
		dataset.addSeries(maxSeries);
		
		JFreeChart xylineChart = ChartFactory.createXYLineChart("", "Generation", "Fitness", dataset,
				PlotOrientation.VERTICAL, true, false, false);

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		final XYPlot plot = xylineChart.getXYPlot();
		plot.getRangeAxis().setRange(10,40);
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesShapesVisible(0, false);
		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesShapesVisible(1, false);
		plot.setRenderer(renderer);
		setContentPane(chartPanel);
		pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);
	}
}
