package test;

import geneticAlgorithm.Population;
import geneticAlgorithm.individual.Individual;

import java.util.ArrayList;
import java.util.List;

import config.Param;

public class TestRandomSelection {

	public static void main(String[] args) {
		List<Individual> list = new ArrayList<Individual>();
		for(int i=0; i<6; i++){
			list.add(new Individual(TestBitAllele.initialBitAlleles(5), TestBitAllele::fitness));
		}
		Population pop = new Population(new Param(null), list);
		System.out.println(pop);
		System.out.println("---");
		pop.evolute(1);
	}
}
