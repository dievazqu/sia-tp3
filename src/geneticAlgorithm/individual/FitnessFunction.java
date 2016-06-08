package geneticAlgorithm.individual;

import geneticAlgorithm.allele.Allele;

import java.util.List;

public interface FitnessFunction {

	double calculateFitness(List<Allele> alleles);
}
