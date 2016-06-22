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

	private int generationSize = 2000;
	private int selectionSize = 0;
	private double generationGap = 0.6;
	private double probabilityToCrossover = 0.95;
	private double probabilityToMutate = 0.001;
	private MutationType mutationType = MutationType.UNIFORM;
	private ReplacementType replacementType = ReplacementType.GENERATIONGAP;
	private CrossoverType crossoverType = CrossoverType.UNIFORM_PARAMETRIZED;
	private SelectionType[] selectionType = new SelectionType[]{
			SelectionType.ELITE,
			SelectionType.BOLTZMANN,
			SelectionType.ELITE,
			SelectionType.BOLTZMANN};
	private double A = 0.5;
	private double B = 0.5;
	private EndConditionType endConditionType = EndConditionType.CONTENT;
	private int maxGeneration = 0;
	private double maxFitness = 20;
	private int maxSteps = 500;
	private int seed = 1;

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
				case "probabilityToCrossover":
					probabilityToCrossover = Double.valueOf(keyValue[1]);
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
					seed = Integer.valueOf(keyValue[1]);
					break;
				case "endConditionType":
					endConditionType = EndConditionType.valueOf(keyValue[1]);
					break;
				}
			}
			RandomUtil.init(seed);
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
	
	public double getProbabilityToCrossover() {
		return probabilityToCrossover;
	}
	
	public double getGenerationGap() {
		return generationGap;
	}
}
