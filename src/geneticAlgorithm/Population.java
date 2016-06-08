package geneticAlgorithm;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.List;

import config.Param;

public class Population {

	private final Param param;
	private final List<Individual> individuals;
	private final IndividualFactory factory;

	public Population(Param param, IndividualFactory factory, List<Individual> individuals) {
		this.param = param;
		this.individuals = individuals;
		this.factory = factory;
	}

	public void evolute(int generations) {
		for (int i = 0; i < generations; i++) {
			next();
		}
	}

	private void next() {
		List<Individual> newGeneration = param.getReplacementType().replace(param, factory, individuals);
		individuals.clear();
		individuals.addAll(newGeneration);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Individual a : individuals) {
			stringBuilder.append(a.toString() + "\n");
		}
		return stringBuilder.toString();
	}
}
