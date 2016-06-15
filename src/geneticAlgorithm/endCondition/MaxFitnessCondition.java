package geneticAlgorithm.endCondition;

import config.Param;
import geneticAlgorithm.Population;
import geneticAlgorithm.individual.Individual;

public class MaxFitnessCondition implements EndCondition{
	
	@Override
	public boolean finish(Param param, Population population) {
		double maxFitness = 0;
		for(Individual i : population.getIndividuals()){
			maxFitness=Math.max(maxFitness, i.getFitness());
		}
		return param.getMaxFitness() <= maxFitness;
	}
	
}
