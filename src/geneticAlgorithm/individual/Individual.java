package geneticAlgorithm.individual;
import geneticAlgorithm.allele.Allele;

import java.util.List;

import config.Param;

public class Individual {
	
	private List<Allele> alleles;
	private FitnessFunction fitnessFunction;
	private Integer fitness;
	
	public Individual(List<Allele> alleles, FitnessFunction fitnessFunction){
		this.alleles=alleles;
		this.fitnessFunction=fitnessFunction;
	}
	
	public int getFitness(){
		if(fitness==null){
			fitness=fitnessFunction.calculateFitness(alleles);
		}
		return fitness;
	}
	
	public FitnessFunction getFitnessFunction() {
		return fitnessFunction;
	}
	
	public List<Allele> getAlleles() {
		return alleles;
	}
	
	public Allele getAlleleAt(int i){
		return alleles.get(i);
	}
	
	public static List<Individual> reproduce(Param param, Individual i1, Individual i2){
		if(!i1.getClass().equals(i2.getClass()) || i1.alleles.size()!=i2.alleles.size()){
			throw new IllegalArgumentException();
		}
		return param.getCrossoverType().reproduce(i1, i2);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Allele a : alleles){
			stringBuilder.append(a.toString()+" - ");
		}
		return stringBuilder.toString();
	}
}
