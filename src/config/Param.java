package config;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import geneticAlgorithm.crossover.CrossoverType;
import geneticAlgorithm.endCondition.EndConditionType;
import geneticAlgorithm.mutation.MutationType;
import geneticAlgorithm.replacement.ReplacementType;
import geneticAlgorithm.selection.SelectionType;
import util.RandomUtil;

public final class Param {

	private ReplacementType replacementType = ReplacementType.ALL;
	private CrossoverType crossoverType = CrossoverType.UNIFORM_PARAMETRIZED;
	private SelectionType[] selectionType = new SelectionType[]{SelectionType.ELITE, SelectionType.ELITE, SelectionType.ELITE, SelectionType.ELITE};
	private EndConditionType endConditionType = EndConditionType.GENERATIONS;
	private int maxGeneration = 1000;
	private double maxFitness = 20;
	private int generationSize = 1000;
	private int selectionSize = 400;
	private double probabilityToMutate;
	private MutationType mutationType;
	private int maxSteps;
	private double A;
	private double B;

	public Param(String fileName) {
		selectionType = new SelectionType[4];
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
				case "selectionType1":
					selectionType[0] = SelectionType.valueOf(keyValue[1]);
					break;
				case "selectionType2":
					selectionType[1] = SelectionType.valueOf(keyValue[1]);
					break;
				case "selectionType3":
					selectionType[2] = SelectionType.valueOf(keyValue[1]);
					break;
				case "selectionType4":
					selectionType[3] = SelectionType.valueOf(keyValue[1]);
					break;
				case "mutationType":
					mutationType = MutationType.valueOf(keyValue[1]);
					break;
				case "selectionSize":
					selectionSize = Integer.valueOf(keyValue[1]);
					break;
				case "generationSize":
					generationSize = Integer.valueOf(keyValue[1]);
					break;
				case "maxGeneration":
					maxGeneration = Integer.valueOf(keyValue[1]);
					break;
				case "maxSteps":
					maxSteps = Integer.valueOf(keyValue[1]);
					break;
				case "maxFitness":
					maxFitness = Double.valueOf(keyValue[1]);
					break;
				case "probabilityToMutate":
					probabilityToMutate = Double.valueOf(keyValue[1]);
					break;
				case "A":
					A = Double.valueOf(keyValue[1]);
					break;
				case "B":
					B = Double.valueOf(keyValue[1]);
					break;
				case "seed":
					RandomUtil.init(Integer.valueOf(keyValue[1]));
					break;
				case "endConditionType":
					endConditionType = EndConditionType.valueOf(keyValue[1]);
					break;
				}
			}
			scanner.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CrossoverType getCrossoverType() {
		return crossoverType;
	}

	public ReplacementType getReplacementType() {
		return replacementType;
	}

	public SelectionType getSelectionType(int i) {
		return selectionType[i];
	}

	public int getSelectionSize() {
		return selectionSize;
	}

	public double getProbabilityToMutate() {
		return probabilityToMutate;
	}
	
	public double getA() {
		return A;
	}
	
	public double getB() {
		return B;
	}
	
	public MutationType getMutationType() {
		return mutationType;
	}
	
	public EndConditionType getEndConditionType() {
		return endConditionType;
	}
	
	public int getMaxGeneration() {
		return maxGeneration;
	}
	
	public int getGenerationSize() {
		return generationSize;
	}
	
	public double getMaxFitness() {
		return maxFitness;
	}
	
	public int getMaxSteps() {
		return maxSteps;
	}
	
}
