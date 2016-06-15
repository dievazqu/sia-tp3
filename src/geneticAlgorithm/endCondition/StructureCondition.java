package geneticAlgorithm.endCondition;

import java.util.List;

import config.Param;
import geneticAlgorithm.Population;
import geneticAlgorithm.individual.Individual;

public class StructureCondition implements EndCondition {
	@Override
	public boolean finish(Param param, Population population) {
		double mean=0;
		double diff=0;
		List<Individual> individuals = population.getIndividuals();
		for (Individual i : individuals) {
			mean+=i.getFitness();
		}
		mean/=individuals.size();
		for (Individual i : individuals) {
			diff+=Math.abs(mean-i.getFitness());
		}
		diff/=individuals.size();
		return diff<2.5;
	}
}
