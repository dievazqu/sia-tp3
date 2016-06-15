package geneticAlgorithm;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.List;

import config.Param;

public class Population {

	private final Param param;
	private List<Individual> individuals;
	private final IndividualFactory factory;
	private int generation;

	public Population(Param param, IndividualFactory factory, List<Individual> individuals) {
		this.param = param;
		this.individuals = individuals;
		this.factory = factory;
		generation = 0;
	}

	public void evolute() {
		while (!param.getEndConditionType().finish(param, this)) {
			next();
		}
	}

	private void next() {
		individuals = param.getReplacementType().replace(param, factory, individuals, generation);
		generation++;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Individual a : individuals) {
			stringBuilder.append(a.toString() + "\n");
		}
		return stringBuilder.toString();
	}

	public int getGeneration() {
		return generation;
	}

	public List<Individual> getIndividuals() {
		return individuals;
	}
}
