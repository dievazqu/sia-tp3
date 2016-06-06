package geneticAlgorithm.selection;

import geneticAlgorithm.individual.Individual;

import java.util.List;

public enum SelectionType {
	ELITE(null),
	RANDOM(new RandomSelection()),
	ROULETTE(null),
	UNIVERSAL(null),
	BOTLZMANN(null),
	TOURNAMENT_DETERMINISTIC(null),
	TOURNAMENT_PROBABILISTIC(null),
	RANKING(null);
	
	private Selectionable selectionable;
	
	private SelectionType(Selectionable selectionable){
		this.selectionable=selectionable;
	}
	
	public List<Individual> selection(List<Individual> list, int size){
		return selectionable.selection(list, size);
	}
}
