package geneticAlgorithm.individual;

import geneticAlgorithm.allele.Allele;

import java.util.ArrayList;
import java.util.List;

public class ArcherFactory implements IndividualFactory{

	@Override
	public Individual createIndividual(List<Allele> list) {
		List<Allele> allele = new ArrayList<Allele>();
		for(Allele a : list){
			allele.add(a.clone());
		}
		return new Archer1(allele);
	}
}
