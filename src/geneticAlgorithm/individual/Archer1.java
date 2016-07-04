package geneticAlgorithm.individual;

import java.util.List;

import geneticAlgorithm.allele.Allele;

public class Archer1 extends Unit{

	public Archer1(List<Allele> alleles) {
		super(alleles);
	}

	@Override
	public double getAttackMultiplier() {
		return 0.9;
	}

	@Override
	public double getDefenseMultiplier() {
		return 0.1;
	}

	@Override
	public double getAgiMultiplier() {
		return 1.3;
	}

	@Override
	public double getStrMultiplier() {
		return 0.6;
	}

	@Override
	public double getResMultiplier() {
		return 0.6;
	}

	@Override
	public double getExpMultiplier() {
		return 1.2;
	}

	@Override
	public double getHPMultiplier() {
		return 0.5;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Allele a : alleles){
			stringBuilder.append(a.toString()+" - ");
		}
		stringBuilder.append(" fitness: "+String.format("%.2f",getFitness()));
		stringBuilder.append("\nFU: "+String.format("%.2f",getStr())+" - ");
		stringBuilder.append("AG: "+String.format("%.2f",getAgi())+" - ");
		stringBuilder.append("EX: "+String.format("%.2f",getExp())+" - ");
		stringBuilder.append("RE: "+String.format("%.2f",getRes())+" - ");
		stringBuilder.append("VI: "+String.format("%.2f",getHP()));
		return stringBuilder.toString();
	}

}
