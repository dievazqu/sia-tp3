package config;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import geneticAlgorithm.crossover.CrossoverType;
import geneticAlgorithm.replacement.ReplacementType;
import geneticAlgorithm.selection.SelectionType;

public final class Param {

	private ReplacementType replacementType;
	private CrossoverType crossoverType;
	private SelectionType selectionType;
	private int selectionSize;
	private double probabilityToMutate;

	public Param(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				String[] keyValue = scanner.next().split("=");
				switch (keyValue[0]) {
				case "replacementType":
					replacementType = ReplacementType.valueOf(keyValue[1]);
					break;
				case "crossoverType":
					crossoverType = CrossoverType.valueOf(keyValue[1]);
					break;
				case "selectionType":
					selectionType = SelectionType.valueOf(keyValue[1]);
					break;
				case "selectionSize":
					selectionSize = Integer.valueOf(keyValue[1]);
					break;
				case "probabilityToMutate":
					probabilityToMutate = Double.valueOf(keyValue[1]);
					break;
				}
			}
			scanner.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
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
