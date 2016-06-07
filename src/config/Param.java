package config;

import geneticAlgorithm.crossover.CrossoverType;
import geneticAlgorithm.replacement.ReplacementType;
import geneticAlgorithm.selection.SelectionType;

public final class Param {

	private final ReplacementType replacementType;
	private final CrossoverType crossoverType;
	private final SelectionType selectionType;
	private final int selectionSize;
	private final double probabilityToMutate;

	public Param(String fileName) {
		// TODO: levantar de archivo.
		replacementType = ReplacementType.ALL;
		crossoverType = CrossoverType.UNIFORM_PARAMETRIZED;
		selectionType = SelectionType.ROULETTE;
		selectionSize = 3;
		probabilityToMutate = 0.05;
	}

	public Param(ReplacementType replacementType,
			CrossoverType crossoverType,
			SelectionType selectionType,
			int selectionSize,
			double probabilityToMutate) {
		this.replacementType=replacementType;
		this.crossoverType=crossoverType;
		this.selectionType=selectionType;
		this.selectionSize=selectionSize;
		this.probabilityToMutate=probabilityToMutate;
	}

	public CrossoverType getCrossoverType() {
		return crossoverType;
	}

	public ReplacementType getReplacementType() {
		return replacementType;
	}

	public SelectionType getSelectionType() {
		return selectionType;
	}

	public int getSelectionSize() {
		return selectionSize;
	}

	public double getProbabilityToMutate() {
		return probabilityToMutate;
	}
}
