package geneticAlgorithm.selection;

import java.util.ArrayList;
import java.util.List;

import geneticAlgorithm.individual.Individual;

public class TournamentProbabilisticSelection implements Selectionable {

	private static final double R = 0.75;
	
	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		List<Individual> selection = new ArrayList<Individual>();

		for (int i = 0; i < sizeOfNewList; i++) {
			Individual i1 = list.get((int) (Math.random() * list.size()));
			Individual i2 = list.get((int) (Math.random() * list.size()));
			boolean getBest = Math.random() < R;
			if (i1.getFitness() > i2.getFitness()) {
				selection.add(i, getBest ? i1 : i2);
			} else {
				selection.add(i, getBest ? i2 : i1);
			}
		}

		return selection;
	}

}
