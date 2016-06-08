package geneticAlgorithm.replacement;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.List;

import config.Param;

public enum ReplacementType {
	ALL(new ReplacementAll()), REPLACE_2(new Replacement2()), REPLACE_3(new Replacement3()), MIXED(null);

	private Replacement replacement;

	private ReplacementType(Replacement replacement) {
		this.replacement = replacement;
	}

	public List<Individual> replace(Param param, IndividualFactory factory, List<Individual> generation) {
		return replacement.replace(param, factory, generation);
	}
}
