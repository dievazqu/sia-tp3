package geneticAlgorithm.selection;

import java.util.ArrayList;
import java.util.List;

import geneticAlgorithm.individual.Individual;
import util.RandomUtil;

public class TournamentProbabilisticSelection implements Selectionable {

	private static final double R = 0.75;
	
	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		List<Individual> selection = new ArrayList<Individual>();

		for (int i = 0; i < sizeOfNewList; i++) {
			Individual i1 = list.get(RandomUtil.getRandom(list.size()));
			Individual i2 = list.get(RandomUtil.getRandom(list.size()));
			boolean getBest = RandomUtil.getRandom() < R;
			if (i1.getFitness() > i2.getFitness()) {
				selection.add(i, getBest ? i1 : i2);
			} else {
				selection.add(i, getBest ? i2 : i1);
			}
		}

		return selection;
	}

}
