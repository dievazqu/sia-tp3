package geneticAlgorithm.crossover;

import geneticAlgorithm.individual.Individual;

import java.util.List;

public enum CrossoverType {
	ONE_POINT(new OnePointCrossover()),
	TWO_POINT(null),
	ANULAR(null),
	UNIFORM_PARAMETRIZED(null);

	CrossoverReproduction crossoverReproduction;
	
	private CrossoverType(CrossoverReproduction crossoverReproduction){
		this.crossoverReproduction=crossoverReproduction;
	}
	
	public List<Individual> reproduce(Individual i1, Individual i2){
		return crossoverReproduction.reproduce(i1, i2);
	}
	
	
}
