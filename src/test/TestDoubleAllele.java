package test;

import geneticAlgorithm.Population;
import geneticAlgorithm.allele.DoubleAllele;
import geneticAlgorithm.crossover.CrossoverType;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.replacement.ReplacementType;
import geneticAlgorithm.selection.SelectionType;

import java.util.ArrayList;
import java.util.List;

import config.Param;

public class TestDoubleAllele {

	private static final int alleleSize = 10;
	private static final int generationSize = 10;
	private static final int maxEpochs = 1000;

	public static void main(String[] args) {
		List<Individual> list = new ArrayList<Individual>();
		for (int i = 0; i < generationSize; i++) {
			list.add(new Individual(DoubleAllele
					.initialDoubleAlleles(alleleSize),
					DoubleAllele::fitnessIncreasing));
		}
		Population pop = new Population(new Param(
				ReplacementType.ALL,
				CrossoverType.UNIFORM_PARAMETRIZED,
				SelectionType.ROULETTE,
				3,
				0.05)
		, list);
		for (int i = 0; i < maxEpochs; i++) {
			System.out.println(pop);
			pop.evolute(1);
		}
	}
}
