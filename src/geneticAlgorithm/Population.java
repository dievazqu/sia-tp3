package geneticAlgorithm;
import geneticAlgorithm.individual.Individual;

import java.util.List;

import config.Param;

public class Population {

	private final Param param;
	private final List<Individual> individuals;
	
	public Population(Param param, List<Individual> individuals){
		this.param=param;
		this.individuals=individuals;
	}
	
	public void evolute(int generations){
		for(int i=0; i<generations; i++){
			next();
		}
	}
	
	private void next(){
		List<Individual> selection = param.getSelectionType().selection(individuals, param.getSelectionSize());
		System.out.println(selection);
		//TODO: reproducirse
		//TODO: amoldar al tamano de la poblacion
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Individual a : individuals){
			stringBuilder.append(a.toString()+"\n");
		}
		return stringBuilder.toString();
	}
}
