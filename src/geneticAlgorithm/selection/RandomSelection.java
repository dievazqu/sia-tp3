package geneticAlgorithm.selection;

import geneticAlgorithm.individual.Individual;

import java.util.ArrayList;
import java.util.List;

public class RandomSelection implements Selectionable {

	@Override
	public List<Individual> selection(List<Individual> list, int sizeOfNewList, int generation) {
		int size = list.size();
		List<Individual> ans = new ArrayList<Individual>(sizeOfNewList);
		for (int i = 0; i < sizeOfNewList; i++) {
			int randomIndex = (int) (Math.random() * size);
			ans.add(list.get(randomIndex));
		}
		return ans;
	}

}
