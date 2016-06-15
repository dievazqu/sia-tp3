package geneticAlgorithm.selection;

import java.util.ArrayList;
import java.util.List;

import geneticAlgorithm.individual.Individual;
import util.RandomUtil;

public class TournamentDeterministicSelection implements Selectionable {
	
	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		List<Individual> selection = new ArrayList<Individual>();
		
		for (int i = 0; i < sizeOfNewList; i++) {
			Individual i1 = list.get(RandomUtil.getRandom(list.size()));
			Individual i2 = list.get(RandomUtil.getRandom(list.size()));
			if (i1.getFitness() > i2.getFitness()) {
				selection.add(i, i1);
			} else {
				selection.add(i, i2);
			}
		}
		
		return selection;
	}

}
