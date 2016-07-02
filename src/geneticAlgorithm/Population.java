package geneticAlgorithm;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.List;

import ui.GraphicChart;
import util.Pair;
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

	public void evolute(){
		while (!param.getEndConditionType().finish(param, this)) {
			next();
		}
		param.getEndConditionType().clear();
	}
	
	public void evolute(GraphicChart graphicChart) {
		while (!param.getEndConditionType().finish(param, this)) {
			next();
			graphicChart.addAvgValue(generation, averageFitness());
			graphicChart.addMaxValue(generation, maxFitness());
			graphicChart.addMinValue(generation, minFitness());
		}
		param.getEndConditionType().clear();
	}
	
	public void evolute(List<Pair> serie) {
		while (!param.getEndConditionType().finish(param, this)) {
			next();
			serie.add(new Pair(generation, maxFitness()));
		}
		param.getEndConditionType().clear();
	}
	
	public double averageFitness(){
		return individuals.stream().mapToDouble(i->i.getFitness()).average().getAsDouble();
	}
	
	public double maxFitness(){
		return individuals.stream().mapToDouble(i->i.getFitness()).max().getAsDouble();
	}
	
	public double minFitness(){
		return individuals.stream().mapToDouble(i->i.getFitness()).min().getAsDouble();
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
