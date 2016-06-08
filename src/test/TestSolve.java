package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import config.Param;
import geneticAlgorithm.Population;
import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.allele.ItemAllele;
import geneticAlgorithm.individual.FitnessFunction;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.Warrior1;
import geneticAlgorithm.item.Item;
import geneticAlgorithm.item.ItemsProvider;

public class TestSolve {

	private static final int generationSize = 10;
	private static final int maxEpochs = 100;
	
	private static ItemsProvider weapons;
	private static ItemsProvider boots;
	private static ItemsProvider helmets;
	private static ItemsProvider gloves;
	private static ItemsProvider mail;

	public static void main(String[] args) {
		weapons = new ItemsProvider(parseItems("equipamiento/armas.tsv"));
		boots = new ItemsProvider(parseItems("equipamiento/botas.tsv"));
		helmets = new ItemsProvider(parseItems("equipamiento/cascos.tsv"));
		gloves = new ItemsProvider(parseItems("equipamiento/guantes.tsv"));
		mail = new ItemsProvider(parseItems("equipamiento/pecheras.tsv"));
		
		FitnessFunction fitnessFunction = new Warrior1();
		
		List<Individual> list = new ArrayList<Individual>();
		for(int i=0; i<generationSize; i++){
			list.add(new Individual(getRandomCombination(), fitnessFunction));
		}
		Population pop = new Population(new Param("config/default"), list);
		for(int i=0; i<maxEpochs; i++){
			System.out.println(pop);
			pop.evolute(1);
		}
	}

	private static List<Allele> getRandomCombination() {
		List<Allele> alleles = new LinkedList<>();
		alleles.add(new ItemAllele(weapons, weapons.getRandomIndex()));
		alleles.add(new ItemAllele(boots, boots.getRandomIndex()));
		alleles.add(new ItemAllele(helmets, helmets.getRandomIndex()));
		alleles.add(new ItemAllele(gloves, gloves.getRandomIndex()));
		alleles.add(new ItemAllele(mail, mail.getRandomIndex()));
		return alleles;
	}

	private static List<Item> parseItems(String fileName) {
		List<Item> items = new LinkedList<>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			// Skip first line, it doesn't have significant values.
			scanner.nextLine();
			while (scanner.hasNext()) {
				Scanner lineScanner = new Scanner(scanner.nextLine());
				// Should we use the id?
				int id = lineScanner.nextInt();
				double str = lineScanner.nextDouble();
				double agi = lineScanner.nextDouble();
				double exp = lineScanner.nextDouble();
				double res = lineScanner.nextDouble();
				double health = lineScanner.nextDouble();
				items.add(new Item(str, agi, exp, res, health));
				lineScanner.close();
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

}
