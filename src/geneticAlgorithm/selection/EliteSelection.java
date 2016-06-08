package geneticAlgorithm.selection;

import geneticAlgorithm.individual.Individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EliteSelection implements Selectionable {

	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList) {
		Collections.sort(list, (a,b) -> Double.compare(b.getFitness(), a.getFitness()));
		return new ArrayList<Individual>(list.subList(0, sizeOfNewList));
	}
}
