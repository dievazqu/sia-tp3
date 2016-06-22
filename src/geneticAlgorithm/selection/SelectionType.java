package geneticAlgorithm.selection;

import java.util.List;

import geneticAlgorithm.individual.Individual;

public enum SelectionType {
	
	ELITE(new EliteSelection()),
	RANDOM(new RandomSelection()),
	ROULETTE(new RouletteSelection()),
	UNIVERSAL(new UniversalSelection()),
	BOLTZMANN(new BoltzmannSelection(0.9)),
	BOLTZMANN99(new BoltzmannSelection(0.99)),
	TOURNAMENT_DETERMINISTIC(new TournamentDeterministicSelection()),
	TOURNAMENT_PROBABILISTIC(new TournamentProbabilisticSelection()),
	RANKING(new RankingSelection());
	
	private Selectionable selectionable;
	
	private SelectionType(Selectionable selectionable){
		this.selectionable=selectionable;
	}
	
	public List<Individual> selection(List<Individual> list, int size, int generation){
		return selectionable.selection(list, size, generation);
	}
}
