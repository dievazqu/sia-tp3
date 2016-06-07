package geneticAlgorithm.replacement;

import geneticAlgorithm.individual.Individual;

import java.util.List;

import config.Param;

public enum ReplacementType {
	ALL(new ReplacementAll()),
	REPLACE_2(null),
	REPLACE_3(null),
	MIXED(null);

	private Replacement replacement;

	private ReplacementType(Replacement replacement) {
		this.replacement = replacement;
	}

	public List<Individual> replace(Param param, List<Individual> generation) {
		return replacement.replace(param, generation);
	}
}
