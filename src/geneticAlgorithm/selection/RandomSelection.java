package geneticAlgorithm.selection;

import java.util.ArrayList;
import java.util.List;

import geneticAlgorithm.individual.Individual;
import util.RandomUtil;

public class RandomSelection implements Selectionable {

	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		int size = list.size();
		List<Individual> ans = new ArrayList<Individual>(sizeOfNewList);
		for (int i = 0; i < sizeOfNewList; i++) {
			int randomIndex = RandomUtil.getRandom(size);
			ans.add(list.get(randomIndex));
		}
		return ans;
	}

}
