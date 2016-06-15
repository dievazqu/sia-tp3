package geneticAlgorithm.replacement;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

import config.Param;

public class ReplacementAll extends BaseReplacement implements Replacement {

	// All
	@Override
	public List<Individual> chooseNextGeneration(Param param, List<Individual> generation, List<Individual> children, int generationNumber) {
		return children;
	}

	@Override
	public int getSelectionSize(Param param, int generationSize) {
		return generationSize;
	}
}
