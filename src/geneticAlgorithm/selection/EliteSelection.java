package geneticAlgorithm.selection;

import geneticAlgorithm.individual.Individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EliteSelection implements Selectionable {

	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		Collections.sort(list);
		return new ArrayList<Individual>(list.subList(0, sizeOfNewList));
	}
}
