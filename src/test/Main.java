package test;

import geneticAlgorithm.Population;
import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.allele.HeightAllele;
import geneticAlgorithm.allele.ItemAllele;
import geneticAlgorithm.individual.ArcherFactory;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;
import geneticAlgorithm.item.ItemsProvider;

import java.awt.Color;
import java.util.ArrayList;
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

import ui.GraphicChart;
import config.ItemParser;
import config.Param;

public class Main {

	private static ItemsProvider weapons;
	private static ItemsProvider boots;
	private static ItemsProvider helmets;
	private static ItemsProvider gloves;
	private static ItemsProvider mail;

	private Main() {
		Param param = new Param("config/default");
		weapons = ItemParser.parseItems("equipamiento/armas.tsv");
		boots = ItemParser.parseItems("equipamiento/botas.tsv");
		helmets = ItemParser.parseItems("equipamiento/cascos.tsv");
		gloves = ItemParser.parseItems("equipamiento/guantes.tsv");
		mail = ItemParser.parseItems("equipamiento/pecheras.tsv");

		List<Individual> list = createRandomIndividuals(param
				.getGenerationSize());
		Population pop = new Population(param, new ArcherFactory(), list);
		GraphicChart graphicChart = new GraphicChart();
		pop.evolute(graphicChart);
		System.out.println(pop);
		graphicChart.draw();
	}

	private List<Allele> getRandomCombination() {
		List<Allele> alleles = new LinkedList<>();
		alleles.add(HeightAllele.getRandomAllele());
		alleles.add(new ItemAllele(weapons, weapons.getRandomIndex()));
		alleles.add(new ItemAllele(boots, boots.getRandomIndex()));
		alleles.add(new ItemAllele(helmets, helmets.getRandomIndex()));
		alleles.add(new ItemAllele(gloves, gloves.getRandomIndex()));
		alleles.add(new ItemAllele(mail, mail.getRandomIndex()));
		return alleles;
	}

	private List<Individual> createRandomIndividuals(int generationSize) {
		IndividualFactory factory = new ArcherFactory();
		List<Individual> list = new ArrayList<Individual>();
		for (int i = 0; i < generationSize; i++) {
			list.add(factory.createIndividual(getRandomCombination()));
		}
		return list;
	}

	public static void main(String[] args) {
		new Main();
	}

}
