package geneticAlgorithm.replacement;

import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

import config.Param;

public class Replacement2 implements Replacement {
	@Override
	public List<Individual> replace(Param param, IndividualFactory factory, List<Individual> generation) {
		List<Individual> selection = param.getSelectionType().selection(generation, param.getSelectionSize());
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
		int size = generation.size()-children.size(); // N-k
		for(int i=0; i<size; i++){
			children.add(generation.remove((int)(Math.random()*generation.size())));
		}
		return children;
	}
}
