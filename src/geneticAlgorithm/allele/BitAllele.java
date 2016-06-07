package geneticAlgorithm.allele;

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
}
