package test;

import geneticAlgorithm.Population;
import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.allele.HeightAllele;
import geneticAlgorithm.allele.ItemAllele;
import geneticAlgorithm.individual.ArcherFactory;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;
import geneticAlgorithm.item.ItemsProvider;
import geneticAlgorithm.selection.SelectionType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ui.GraphicChart;
import ui.GraphicStatisticsChart;
import util.Pair;
import config.ItemParser;
import config.Param;

public class Main {

	private static ItemsProvider weapons;
	private static ItemsProvider boots;
	private static ItemsProvider helmets;
	private static ItemsProvider gloves;
	private static ItemsProvider mail;

	private Main(String[] args) {
		Param param = new Param("config/default");
		weapons = ItemParser.parseItems("equipamiento/armas.tsv");
		boots = ItemParser.parseItems("equipamiento/botas.tsv");
		helmets = ItemParser.parseItems("equipamiento/cascos.tsv");
		gloves = ItemParser.parseItems("equipamiento/guantes.tsv");
		mail = ItemParser.parseItems("equipamiento/pecheras.tsv");
		runTests(param);
		//runUniqueTest(param);
	}

	public void runUniqueTest(Param param) {
		List<Individual> list = createRandomIndividuals(param
				.getGenerationSize());
		GraphicChart gc = new GraphicChart();
		Population pop = makePopulation(param, list, gc);
		gc.draw();
		double max = 0;
		Individual maxI = null;
		for (Individual i : pop.getIndividuals()) {
			if (i.getFitness() > max) {
				maxI = i;
				max = i.getFitness();
			}
		}
		System.out.println(maxI);
		System.out.println();
		System.out.println(pop);
	}

	public void runTests(Param param) {
		
		
		SelectionType[] s = {SelectionType.RANDOM, SelectionType.BOLTZMANN99, SelectionType.RANKING, SelectionType.ROULETTE,
				SelectionType.TOURNAMENT_DETERMINISTIC, SelectionType.TOURNAMENT_PROBABILISTIC, SelectionType.UNIVERSAL, SelectionType.BOLTZMANN, SelectionType.ELITE};
		List<Pair>[] lists = new LinkedList[s.length];
		GraphicStatisticsChart gsc = new GraphicStatisticsChart();
		for (int i = 0; i < s.length; i++){
			lists[i]=new LinkedList<Pair>();
			param.setSelectionType(s[i], 1);
			param.setSelectionType(s[i], 3);
			List<Individual> list = createBadIndividuals(param
					.getGenerationSize());
			Population pop = makePopulation(param, list, lists[i]);
			double maxFitness = pop.maxFitness();
			double avgFitness = pop.averageFitness();

			gsc.addPoints(lists[i], s[i].name());
			System.out.println(String.valueOf(maxFitness).replace('.', ','));
		}
		gsc.draw("Generation", "MaxFitness");
	}

	public Population makePopulation(Param param,
			List<Individual> initialPopulation) {
		Population pop = new Population(param, new ArcherFactory(),
				initialPopulation);
		pop.evolute();
		return pop;
	}

	public Population makePopulation(Param param,
			List<Individual> initialPopulation, GraphicChart gc) {
		Population pop = new Population(param, new ArcherFactory(),
				initialPopulation);
		pop.evolute(gc);
		return pop;
	}
	
	public Population makePopulation(Param param,
			List<Individual> initialPopulation, List<Pair> serie) {
		Population pop = new Population(param, new ArcherFactory(),
				initialPopulation);
		pop.evolute(serie);
		return pop;
	}

	/* 1,9151925720 - Item #102 - Item #199 - Item #173 - Item #109 - Item #78 */

	private List<Individual> createBadIndividuals(int generationSize) {
		IndividualFactory factory = new ArcherFactory();
		List<Individual> list = new ArrayList<Individual>();
		for (int i = 0; i < generationSize; i++) {
			list.add(factory.createIndividual(getBadCombination()));
		}
		return list;
	}

	private List<Allele> getBadCombination() {
		List<Allele> alleles = new LinkedList<>();
		alleles.add(new HeightAllele(1.9151925720));
		alleles.add(new ItemAllele(weapons, 102));
		alleles.add(new ItemAllele(boots, 199));
		alleles.add(new ItemAllele(helmets, 173));
		alleles.add(new ItemAllele(gloves, 109));
		alleles.add(new ItemAllele(mail, 78));
		return alleles;
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
		new Main(args);
	}

}
