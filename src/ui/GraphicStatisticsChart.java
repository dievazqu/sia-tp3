package ui;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

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

import util.Pair;

public class GraphicStatisticsChart extends ApplicationFrame{
	
	private List<XYSeries> series;
	
	private final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};
	
	public GraphicStatisticsChart(){
		super("SIA-TP3");
		series = new LinkedList<XYSeries>();
	}
	
	public void addPoints(List<Pair> list, String seriesName){
		XYSeries serie = new XYSeries(seriesName);
		for(Pair p : list){
			serie.add(p.x, p.y);
		}
		series.add(serie);
	}
	
	public void draw(String xLabel, String yLabel){
		final XYSeriesCollection dataset = new XYSeriesCollection();
		for(XYSeries serie : series){
			dataset.addSeries(serie);
		}
		
		JFreeChart xylineChart = ChartFactory.createXYLineChart("", xLabel, yLabel, dataset,
				PlotOrientation.VERTICAL, true, false, false);
				
				/*ChartFactory.createXYLineChart("", xLabel, yLabel, dataset,
				PlotOrientation.VERTICAL, true, false, false);*/

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		final XYPlot plot = xylineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		for(int i=0; i<series.size(); i++){
			renderer.setSeriesPaint(i, colors[i]);
			renderer.setSeriesShapesVisible(i, true);
			renderer.setLinesVisible(false);
		}
		plot.setRenderer(renderer);
		setContentPane(chartPanel);
		pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);
	}
}
