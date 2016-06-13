package geneticAlgorithm.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import geneticAlgorithm.individual.Individual;

public class BoltzmannSelection implements Selectionable {

	Map<Individual, Double> mem;
	
	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		double T = getTemperature(generation);
		mem = new TreeMap<Individual, Double>();
		long totalFitness = 0;
		for(Individual i : list){
			totalFitness += getSpecialFitness(i, T);
		}
		TreeMap<Double, Individual> relativesFitness = new TreeMap<Double, Individual>();
		long relativeFitness = 0;
		for(Individual i : list){
			relativesFitness.put((double)relativeFitness/totalFitness, i);
			relativeFitness+=getSpecialFitness(i, T);
		}
		List<Individual> selection = new ArrayList<Individual>();
		for(int i=0; i<sizeOfNewList; i++){
			selection.add(relativesFitness.floorEntry(Math.random()).getValue());
		}
		return selection;
	}
	
	private double getSpecialFitness(Individual i, double T){
		Double number = mem.get(i);
		if(number==null){
			number = Math.pow(Math.E, i.getFitness()/T);
			mem.put(i, number);
		}
		return number;
	}

	private double getTemperature(int generation) {
		return Math.max(1, 100*Math.pow(0.9, generation)); 
	}
	
}
