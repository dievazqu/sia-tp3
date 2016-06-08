package geneticAlgorithm.individual;

import java.util.List;

import geneticAlgorithm.allele.Allele;

public class ArcherFactory implements IndividualFactory{

	@Override
	public Individual createIndividual(List<Allele> list) {
		return new Archer1(list);
	}
}
