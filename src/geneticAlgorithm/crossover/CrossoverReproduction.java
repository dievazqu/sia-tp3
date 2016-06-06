package geneticAlgorithm.crossover;

import geneticAlgorithm.individual.Individual;

import java.util.List;

public interface CrossoverReproduction{
	public List<Individual> reproduce(Individual i1, Individual i2);
}
