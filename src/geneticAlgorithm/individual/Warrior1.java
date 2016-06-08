package geneticAlgorithm.individual;

import java.util.List;

import geneticAlgorithm.allele.Allele;

public class Warrior1 implements FitnessFunction {

	@Override
	public int calculateFitness(List<Allele> alleles) {
		return (int) (Math.random() * 100);
	}

}
