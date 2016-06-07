package geneticAlgorithm.allele;

import java.util.ArrayList;
import java.util.List;

public class BitAllele extends Allele {

	boolean bit;
	
	public BitAllele(boolean bit){
		this.bit=bit;
	}
	
	@Override
	public Allele clone() {
		return new BitAllele(bit);
	}
	
	public int isOn() {
		return bit?1:0;
	}
	
	@Override
	public String toString() {
		return String.valueOf(isOn());
	}

	@Override
	public void mutate() {
		bit = (Math.random()<0.5);
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
