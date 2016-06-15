package geneticAlgorithm.endCondition;

import java.util.List;

import config.Param;
import geneticAlgorithm.Population;
import geneticAlgorithm.individual.Individual;

public class ContentCondition implements EndCondition {

	int counter = 0;
	double maxFitness = 0;

	@Override
	public boolean finish(Param param, Population population) {
		++counter;
		List<Individual> individuals = population.getIndividuals();
		for(Individual i : individuals){
			if (i.getFitness() > maxFitness) {
				maxFitness = i.getFitness();
				counter = 0;
			}	
		}
		return counter > param.getMaxSteps();
	}

}
