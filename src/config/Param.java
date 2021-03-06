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

	private int generationSize = 170;
	private int selectionSize = 0;
	private double generationGap = 0.6;
	private double probabilityToCrossover = 0.95;
	private double probabilityToMutate = 0.15;
	private MutationType mutationType = MutationType.NOUNIFORM;
	private ReplacementType replacementType = ReplacementType.GENERATIONGAP;
	private CrossoverType crossoverType = CrossoverType.UNIFORM_PARAMETRIZED;
	private SelectionType[] selectionType = new SelectionType[]{
			SelectionType.BOLTZMANN,
			SelectionType.BOLTZMANN99,
			SelectionType.ELITE,
			SelectionType.ROULETTE};
	private double A = 0.6;
	private double B = 0.1;
	private EndConditionType endConditionType = EndConditionType.CONTENT;
	private int maxGeneration = 300;
	private double maxFitness = 0;
	private int maxSteps = 1000;
	private int seed = 1234;

	public Param(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				String[] keyValue = scanner.next().split("=");
				keyValue[1]=keyValue[1].toUpperCase();
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
				case "generationGap":
					generationGap = Double.valueOf(keyValue[1]);
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

	public void setSelectionType(SelectionType selectionType, int i) {
		this.selectionType[i] = selectionType;
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
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Generation Size = "+generationSize+"\n");
		str.append("Replacement Type = "+replacementType.name()+"\n");
		if(replacementType==ReplacementType.GENERATIONGAP){
			str.append("Generation Gap = "+generationGap+"\n");
		}else{
			str.append("Selection Size = "+selectionSize+"\n");
		}
		str.append("Crossover Type = "+crossoverType.name()+"\n");
		str.append("Probability To Crossover = "+probabilityToCrossover+"\n");
		str.append("Mutation Type = "+mutationType.name()+"\n");
		str.append("Probability To Mutate = "+probabilityToMutate+"\n");
		str.append("Selection Type For Crossover = {"+selectionType[0].name()+"("+A+"), "+selectionType[1].name()+"("+(1-A)+")}"+"\n");
		str.append("Selection Type For Replace = {"+selectionType[2].name()+"("+B+"), "+selectionType[3].name()+"("+(1-B)+")}"+"\n");
		str.append("End Condition = "+endConditionType.name()+"\n");
		switch(endConditionType){
			case CONTENT:
				str.append("Max Steps = "+maxSteps+"\n");
				break;
			case MAX_FITNESS:
				str.append("Max Fitness = "+maxFitness+"\n");
				break;
			case GENERATIONS:
				str.append("Generations = "+maxGeneration+"\n");
				break;
		}
		str.append("Random seed = "+seed+"\n");
		return str.toString();
	}
	
}
