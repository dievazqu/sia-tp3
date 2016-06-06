package config;

import geneticAlgorithm.crossover.CrossoverType;
import geneticAlgorithm.replacement.ReplacementType;
import geneticAlgorithm.selection.SelectionType;

public final class Param {

	private final ReplacementType replacementType;
	private final CrossoverType crossoverType;
	private final SelectionType selectionType;
	private final int selectionSize;

	public Param(String fileName) {
		// TODO: levantar de archivo.
		replacementType=ReplacementType.REPLACE_1;
		crossoverType=CrossoverType.ONE_POINT;
		selectionType=SelectionType.RANDOM;
		selectionSize=3;
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
}
