package geneticAlgorithm.endCondition;

import geneticAlgorithm.Population;
import geneticAlgorithm.individual.Individual;

import java.util.Collections;
import java.util.List;

import config.Param;

public class StructureCondition implements EndCondition {

	private double lastAvg = 0.0;
	private final double EPS = 0.0001;

	@Override
	public boolean finish(Param param, Population population) {
		List<Individual> list = population.getIndividuals();
		Collections.sort(list);
		int tenPercent = list.size() / 10;
		double avg = list.subList(0, list.size() - tenPercent)
				.stream().mapToDouble(i -> i.getFitness()).average()
				.getAsDouble();
		if(Math.abs(avg-lastAvg)<EPS){
			return true;
		}
		lastAvg=avg;
		return false;
	}
	
	@Override
	public void clear() {
		lastAvg=0.0;
	}
}
