package geneticAlgorithm.crossover;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

import util.RandomUtil;

public enum CrossoverType {
	ONE_POINT(new OnePointCrossover()),
	TWO_POINT(new TwoPointCrossover()),
	ANULAR(new AnularCrossover()),
	UNIFORM_PARAMETRIZED(new UniformParametrizedCrossover());

	CrossoverReproduction crossoverReproduction;
	
	private CrossoverType(CrossoverReproduction crossoverReproduction){
		this.crossoverReproduction=crossoverReproduction;
	}
	
	public List<Individual> reproduce(IndividualFactory factory, Individual i1, Individual i2, double probabilityToCrossover){
		if(RandomUtil.getRandom()>=probabilityToCrossover){
			List<Individual> list = new ArrayList<Individual>();
			list.add(factory.createIndividual(i1.getAlleles()));
			list.add(factory.createIndividual(i2.getAlleles()));
			return list;
		}
		return crossoverReproduction.reproduce(factory, i1, i2);
	}
	
	
}
