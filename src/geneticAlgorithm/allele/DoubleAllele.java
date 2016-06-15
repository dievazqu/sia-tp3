package geneticAlgorithm.allele;

import java.util.ArrayList;
import java.util.List;

import util.RandomUtil;

/**
 * 
 *	Allele with value between 0 and 1.
 *
 */
public class DoubleAllele extends Allele {
	
	private double value;
	
	public DoubleAllele(double value) {
		this.value=value;
	}

	@Override
	public Allele clone() {
		return new DoubleAllele(value);
	}

	@Override
	public void mutate() {
		value = RandomUtil.getRandom();
	}
	
	public double getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("%.3f", value);
	}
	
	public static int fitnessIncreasing(List<Allele> list){
		int ans = 0;
		int strike=1;
		double last=0;
		for(Allele a : list){
			DoubleAllele da = (DoubleAllele) a;
			if(da.getValue()>last){
				strike*=2;
			}else{
				ans+=strike;
				strike=1;
			}
			last = da.getValue();
		}
		return ans+strike;
	}
	
	public static List<Allele> initialDoubleAlleles(int size){
		List<Allele> list = new ArrayList<Allele>(size);
		for(int i=0; i<size; i++){
			list.add(new DoubleAllele(RandomUtil.getRandom()));
		}
		return list;
	}
}
