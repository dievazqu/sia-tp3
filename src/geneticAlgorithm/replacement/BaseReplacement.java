package geneticAlgorithm.replacement;

import java.util.ArrayList;
import java.util.List;

import config.Param;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;
import util.RandomUtil;

public abstract class BaseReplacement implements Replacement {

	@Override
	public List<Individual> replace(Param param, IndividualFactory factory, List<Individual> generation,
			int generationNumber) {
		int generationSize = generation.size();
		int first = (int)Math.round(param.getA()*getSelectionSize(param, generationSize));
		int second = getSelectionSize(param, generationSize)-first;
		List<Individual> selection = param.getSelectionType(0).selection(generation, first, generationNumber);
		List<Individual> selectionSecond = param.getSelectionType(1).selection(generation, second, generationNumber);
		selection.addAll(selectionSecond);
		List<Individual> children = new ArrayList<Individual>();
		for(int i=1; i<selection.size(); i+=2){
			children.addAll(param.getCrossoverType().reproduce(factory, selection.get(i), selection.get(i-1), param.getProbabilityToCrossover()));
		}
		if(selection.size()%2==1){
			int indexRandom = RandomUtil.getRandom(selection.size()-1);
			children.add(param.getCrossoverType().reproduce(factory,  selection.get(selection.size()-1), selection.get(indexRandom), param.getProbabilityToCrossover()).get(0));
		}
		for(Individual i : children){
			i.mutate(param);
		}
		return chooseNextGeneration(param, generation, children, generationNumber);
	}

	public abstract List<Individual> chooseNextGeneration(Param param, List<Individual> generation, List<Individual> children, int generationNumber);
	
	public int getSelectionSize(Param param, int generationSize){
		return param.getSelectionSize();
	}
}
