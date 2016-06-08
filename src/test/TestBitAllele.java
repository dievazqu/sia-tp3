package test;

import geneticAlgorithm.Population;
import geneticAlgorithm.allele.BitAllele;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

import config.Param;

public class TestBitAllele {

	private static final int alleleSize = 10;
	private static final int generationSize = 10;
	private static final int maxEpochs = 100;
	
	public static void main(String[] args) {
//		List<Individual> list = new ArrayList<Individual>();
//		for(int i=0; i<generationSize; i++){
//			list.add(new Individual(BitAllele.initialBitAlleles(alleleSize), BitAllele::fitness));
//		}
//		Population pop = new Population(new Param("config/default"), list);
//		for(int i=0; i<maxEpochs; i++){
//			System.out.println(pop);
//			pop.evolute(1);
//		}
	}
}
