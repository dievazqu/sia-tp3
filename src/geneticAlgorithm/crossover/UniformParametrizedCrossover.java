package geneticAlgorithm.crossover;

import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.individual.Individual;

import java.util.ArrayList;
import java.util.List;

public class UniformParametrizedCrossover implements CrossoverReproduction {

	@Override
	public List<Individual> reproduce(Individual i1, Individual i2) {
		int size =i1.getAlleles().size();
		List<Allele> child1 = new ArrayList<Allele>(size);
		List<Allele> child2 = new ArrayList<Allele>(size);
		for(int i=0; i<size; i++){
			if(Math.random()<0.5){
				child1.add(i1.getAlleleAt(i).clone());
				child2.add(i2.getAlleleAt(i).clone());
			}else{
				child1.add(i2.getAlleleAt(i).clone());
				child2.add(i1.getAlleleAt(i).clone());
			}
		}
		List<Individual> ans = new ArrayList<Individual>();
		ans.add(new Individual(child1, i1.getFitnessFunction()));
		ans.add(new Individual(child2, i1.getFitnessFunction()));
		return ans;
	}

}