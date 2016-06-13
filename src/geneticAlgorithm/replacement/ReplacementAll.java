package geneticAlgorithm.replacement;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

import config.Param;

public class ReplacementAll implements Replacement {

	@Override
	public List<Individual> replace(Param param, IndividualFactory factory, List<Individual> generation, int generationNumber) {
		List<Individual> selection = param.getSelectionType().selection(generation, generation.size(), generationNumber);
		List<Individual> children = new ArrayList<Individual>();
		for(int i=1; i<selection.size(); i+=2){
			children.addAll(param.getCrossoverType().reproduce(factory, selection.get(i), selection.get(i-1)));
		}
		if(generation.size()%2==1){
			//TODO: preguntar que hacer para este caso.
		}
		for(Individual i : children){
			i.mutate(param.getProbabilityToMutate());
		}
		return children;
	}

}
