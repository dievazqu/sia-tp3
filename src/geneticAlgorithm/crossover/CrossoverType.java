package geneticAlgorithm.crossover;

import java.util.List;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

public enum CrossoverType {
	ONE_POINT(new OnePointCrossover()),
	TWO_POINT(new TwoPointCrossover()),
	ANULAR(new AnularCrossover()),
	UNIFORM_PARAMETRIZED(new UniformParametrizedCrossover());

	CrossoverReproduction crossoverReproduction;
	
	private CrossoverType(CrossoverReproduction crossoverReproduction){
		this.crossoverReproduction=crossoverReproduction;
	}
	
	public List<Individual> reproduce(IndividualFactory factory, Individual i1, Individual i2){
		return crossoverReproduction.reproduce(factory, i1, i2);
	}
	
	
}
