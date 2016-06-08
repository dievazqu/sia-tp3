package geneticAlgorithm.allele;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *	Allele with value between 1.3 and 2.0
 *
 */
public class HeightAllele extends Allele {
	
	private double value;
	
	public HeightAllele(double value) {
		if(value<1.3 || value>2.0){
			throw new IllegalArgumentException("Invalid height");
		}
		this.value=value;
	}

	@Override
	public Allele clone() {
		return new DoubleAllele(value);
	}

	@Override
	public void mutate() {
		value = Math.random()*0.7+1.3;
	}
	
	public double getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("%.3f", value);
	}
	
	public double getAttackModifier(){
		double base = 3*value-5;
		return 0.5-Math.pow(base, 4)+Math.pow(base, 2)+(value/2);
	}
	
	public double getDefenseModifier(){
		double base = 3*value-5;
		return 2+Math.pow(base, 4)-Math.pow(base, 2)-(value/2);
	}
}
