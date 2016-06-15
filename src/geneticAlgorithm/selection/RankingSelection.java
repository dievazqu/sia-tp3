package geneticAlgorithm.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import geneticAlgorithm.individual.Individual;
import util.RandomUtil;

public class RankingSelection implements Selectionable {

	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		Collections.sort(list);

		List<Individual> selection = new ArrayList<>();
		for (int i = 0; i < sizeOfNewList; i++) {
			selection.add(i, getIndividualFromRanking(list));
		}
		return selection;
	}

	private Individual getIndividualFromRanking(List<Individual> individuals) {
		int index = (int) (RandomUtil.getRandom() * RandomUtil.getRandom() * individuals.size());
		return individuals.get(index);
	}

}
