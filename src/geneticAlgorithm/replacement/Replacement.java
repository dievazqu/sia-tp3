package geneticAlgorithm.replacement;

import geneticAlgorithm.individual.Individual;

import java.util.List;

import config.Param;

public interface Replacement {
	List<Individual> replace(Param param, List<Individual> generation);
}
