package geneticAlgorithm.individual;
import geneticAlgorithm.allele.Allele;

import java.util.List;

import config.Param;

public abstract class Individual {
	
	public static List<Individual> reproduce(Param param, IndividualFactory factory, 
			Individual i1, Individual i2){
		if(!i1.getClass().equals(i2.getClass()) || i1.alleles.size()!=i2.alleles.size()){
			throw new IllegalArgumentException();
		}
		return param.getCrossoverType().reproduce(factory, i1, i2);
	}
	
	protected List<Allele> alleles;
	private Double fitness;
	
	public Individual(List<Allele> alleles){
		this.alleles=alleles;
	}
	
	public void mutate(double probability){
		if(probability<0 || probability>1){
			throw new IllegalArgumentException("probability must be between 0 and 1.");
		}
		//TODO: Do both methods
		for(Allele a : alleles){
			if(Math.random()<probability)
				a.mutate();
		}
	}
	
	public double getFitness(){
		if(fitness==null){
			fitness=getFitnessValue();
		}
		return fitness;
	}
	
	public abstract double getFitnessValue();
	
	
	public List<Allele> getAlleles() {
		return alleles;
	}
	
	public Allele getAlleleAt(int i){
		return alleles.get(i);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Allele a : alleles){
			stringBuilder.append(a.toString()+" - ");
		}
		stringBuilder.append(" fitness: "+getFitness());
		return stringBuilder.toString();
	}
}
