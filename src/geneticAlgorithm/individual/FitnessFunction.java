package geneticAlgorithm.individual;

import geneticAlgorithm.allele.Allele;

import java.util.List;

public interface FitnessFunction {

	int calculateFitness(List<Allele> alleles);
}
