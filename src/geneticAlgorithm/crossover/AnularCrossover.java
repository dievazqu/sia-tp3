package geneticAlgorithm.crossover;

import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.individual.Individual;
import geneticAlgorithm.individual.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

import util.RandomUtil;

public class AnularCrossover implements CrossoverReproduction{

	@Override
	public List<Individual> reproduce(IndividualFactory factory, Individual i1, Individual i2) {
		int size = i1.getAlleles().size();
		int k1,l;
		k1 = RandomUtil.getRandom(0, size-1); // 0-indexed instead of 1-indexed
		l = RandomUtil.getRandom(0, size-1); // 0-indexed instead of 1-indexed
		int min = Math.min(k1, (k1+l)%size);
		int max = Math.max(k1, (k1+l)%size);
		List<Allele> child1 = new ArrayList<Allele>(size);
		List<Allele> child2 = new ArrayList<Allele>(size);
		for(int i=0; i<size; i++){
			if(i<=min || i>max){
				child1.add(i1.getAlleleAt(i));
				child2.add(i2.getAlleleAt(i));
			}else{
				child1.add(i2.getAlleleAt(i));
				child2.add(i1.getAlleleAt(i));
			}
		}
		List<Individual> ans = new ArrayList<Individual>();
		ans.add(factory.createIndividual(child1));
		ans.add(factory.createIndividual(child2));
		return ans;
	}
}
