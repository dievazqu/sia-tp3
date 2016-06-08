package geneticAlgorithm.individual;

import java.util.List;

import geneticAlgorithm.allele.Allele;

public interface IndividualFactory {
	public Individual createIndividual(List<Allele> list);
}
