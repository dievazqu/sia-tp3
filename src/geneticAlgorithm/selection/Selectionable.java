package geneticAlgorithm.selection;

import geneticAlgorithm.individual.Individual;

import java.util.List;

public interface Selectionable {
	List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation);
}
