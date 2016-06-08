package test;
import geneticAlgorithm.allele.BitAllele;
import geneticAlgorithm.individual.Individual;
import config.Param;


public class TestReprodution {

	public static void main(String[] args) {
		Individual i1 = new Individual(BitAllele.initialBitAlleles(5), BitAllele::fitness);
		Individual i2 = new Individual(BitAllele.initialBitAlleles(5), BitAllele::fitness);
		System.out.println(i1);
		System.out.println(i2);
		for(Individual i : Individual.reproduce(new Param(null), i1, i2)){
			System.out.println(i);
		};
	}
}
