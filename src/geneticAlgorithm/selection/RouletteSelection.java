package geneticAlgorithm.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import geneticAlgorithm.individual.Individual;
import util.RandomUtil;

public class RouletteSelection implements Selectionable{

	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
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
		for(int i=0; i<sizeOfNewList; i++){
			selection.add(relativesFitness.floorEntry(RandomUtil.getRandom()).getValue());
		}
		return selection;
	}

}
