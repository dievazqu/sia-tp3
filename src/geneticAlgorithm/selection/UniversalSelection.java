package geneticAlgorithm.selection;

import geneticAlgorithm.individual.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class UniversalSelection implements Selectionable{

	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList) {
		long totalFitness = 0;
		for(Individual i : list){
			totalFitness += i.getFitness();
		}
		TreeMap<Double, Individual> relativesFitness = new TreeMap<Double, Individual>();
		long relativeFitness = 0;
		for(Individual i : list){
			relativesFitness.put((double)relativeFitness/totalFitness, i);
			relativeFitness+=i.getFitness();
		}
		List<Individual> selection = new ArrayList<Individual>();
		double r_j = Math.random()/sizeOfNewList;
		for(int i=0; i<sizeOfNewList; i++){
			selection.add(relativesFitness.floorEntry(r_j).getValue());
			r_j+=(1/sizeOfNewList);
		}
		return selection;
	}
}