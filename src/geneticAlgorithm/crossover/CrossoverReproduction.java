package geneticAlgorithm.crossover;

import java.util.List;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

public interface CrossoverReproduction{
	public List<Individual> reproduce(IndividualFactory factory, Individual i1, Individual i2);
}
