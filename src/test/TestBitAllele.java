package test;
import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.allele.BitAllele;
import geneticAlgorithm.individual.Individual;

import java.util.ArrayList;
import java.util.List;

import config.Param;


public class TestBitAllele {

	public static void main(String[] args) {
		Individual i1 = new Individual(initialBitAlleles(5), TestBitAllele::fitness);
		Individual i2 = new Individual(initialBitAlleles(5), TestBitAllele::fitness);
		System.out.println(i1);
		System.out.println(i2);
		for(Individual i : Individual.reproduce(new Param(null), i1, i2)){
			System.out.println(i);
		};
	}
	
	public static int fitness(List<Allele> list){
		int ans = 0;
		for(Allele a : list){
			ans<<=1;
			ans+=((BitAllele) a).isOn();
		}
		return ans;
	}
	
	public static List<Allele> initialBitAlleles(int size){
		List<Allele> list = new ArrayList<Allele>(size);
		for(int i=0; i<size; i++){
			list.add(new BitAllele(Math.random()<0.5));
		}
		return list;
	}
	
	
}
