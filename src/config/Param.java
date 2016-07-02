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

	private int generationSize = 20;
	private int selectionSize = 0;
	private double generationGap = 0.6;
	private double probabilityToCrossover = 0.5;
	private double probabilityToMutate = 0.01;
	private MutationType mutationType = MutationType.NOUNIFORM;
	private ReplacementType replacementType = ReplacementType.ALL;
	private CrossoverType crossoverType = CrossoverType.UNIFORM_PARAMETRIZED;
	private SelectionType[] selectionType = new SelectionType[]{
			SelectionType.ELITE,
			SelectionType.RANDOM,
			SelectionType.ELITE,
			SelectionType.RANDOM};
	private double A = 1;
	private double B = 0;
	private EndConditionType endConditionType = EndConditionType.CONTENT;
	private int maxGeneration = 100;
	private double maxFitness = 20;
	private int maxSteps = 100;
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

	public void setGenerationSize(int generationSize) {
		this.generationSize = generationSize;
	}

	public void setSelectionSize(int selectionSize) {
		this.selectionSize = selectionSize;
	}

	public void setGenerationGap(double generationGap) {
		this.generationGap = generationGap;
	}

	public void setProbabilityToCrossover(double probabilityToCrossover) {
		this.probabilityToCrossover = probabilityToCrossover;
	}

	public void setProbabilityToMutate(double probabilityToMutate) {
		this.probabilityToMutate = probabilityToMutate;
	}

	public void setMutationType(MutationType mutationType) {
		this.mutationType = mutationType;
	}

	public void setReplacementType(ReplacementType replacementType) {
		this.replacementType = replacementType;
	}

	public void setCrossoverType(CrossoverType crossoverType) {
		this.crossoverType = crossoverType;
	}

	public void setSelectionType(SelectionType[] selectionType) {
		this.selectionType = selectionType;
	}

	public void setA(double a) {
		A = a;
	}

	public void setB(double b) {
		B = b;
	}

	public void setEndConditionType(EndConditionType endConditionType) {
		this.endConditionType = endConditionType;
	}

	public void setMaxGeneration(int maxGeneration) {
		this.maxGeneration = maxGeneration;
	}

	public void setMaxFitness(double maxFitness) {
		this.maxFitness = maxFitness;
	}

	public void setMaxSteps(int maxSteps) {
		this.maxSteps = maxSteps;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}
	
	
}
