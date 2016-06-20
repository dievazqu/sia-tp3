package geneticAlgorithm.replacement;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

import config.Param;

public class Replacement3 extends BaseReplacement implements Replacement {
	
		// De los N+K agarra N
		@Override
		public List<Individual> chooseNextGeneration(Param param, List<Individual> generation, List<Individual> children, int generationNumber) {
			List<Individual> ans = new ArrayList<>();
			generation.addAll(children);
			
			int third = (int)Math.round(param.getB()*(generation.size()-children.size()));
			int fourth = param.getSelectionSize()-third;
			List<Individual> selection = param.getSelectionType(2).selection(generation, third, generationNumber);
			List<Individual> selectionSecond = param.getSelectionType(3).selection(generation, fourth, generationNumber);
			ans.addAll(selection);
			ans.addAll(selectionSecond);
			return ans;
		}
}
