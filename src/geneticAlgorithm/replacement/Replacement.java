package geneticAlgorithm.replacement;

import java.util.List;

import config.Param;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

public interface Replacement {
	List<Individual> replace(Param param, IndividualFactory factory, List<Individual> generation);
}
