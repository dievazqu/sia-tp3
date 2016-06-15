package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import config.ItemParser;
import config.Param;
import geneticAlgorithm.Population;
import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.allele.HeightAllele;
import geneticAlgorithm.allele.ItemAllele;
import geneticAlgorithm.individual.Unit;
import geneticAlgorithm.individual.ArcherFactory;
import geneticAlgorithm.individual.FitnessFunction;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;
import geneticAlgorithm.item.ItemsProvider;

public class Main {

	private static ItemsProvider weapons;
	private static ItemsProvider boots;
	private static ItemsProvider helmets;
	private static ItemsProvider gloves;
	private static ItemsProvider mail;

	public static void main(String[] args) {

		Param param = new Param("config/default");
		weapons = ItemParser.parseItems("equipamiento/armas.tsv");
		boots = ItemParser.parseItems("equipamiento/botas.tsv");
		helmets = ItemParser.parseItems("equipamiento/cascos.tsv");
		gloves = ItemParser.parseItems("equipamiento/guantes.tsv");
		mail = ItemParser.parseItems("equipamiento/pecheras.tsv");

		List<Individual> list = createRandomIndividuals(param.getGenerationSize());

		Population pop = new Population(param, new ArcherFactory(), list);
		pop.evolute();
		System.out.println(pop);
	}

	private static List<Allele> getRandomCombination() {
		List<Allele> alleles = new LinkedList<>();
		alleles.add(HeightAllele.getRandomAllele());
		alleles.add(new ItemAllele(weapons, weapons.getRandomIndex()));
		alleles.add(new ItemAllele(boots, boots.getRandomIndex()));
		alleles.add(new ItemAllele(helmets, helmets.getRandomIndex()));
		alleles.add(new ItemAllele(gloves, gloves.getRandomIndex()));
		alleles.add(new ItemAllele(mail, mail.getRandomIndex()));
		return alleles;
	}

	private static List<Individual> createRandomIndividuals(int generationSize) {
		IndividualFactory factory = new ArcherFactory();
		List<Individual> list = new ArrayList<Individual>();
		for (int i = 0; i < generationSize; i++) {
			list.add(factory.createIndividual(getRandomCombination()));
		}
		return list;
	}

}
