package geneticAlgorithm.item;

public class Item {
	
	private double str;
	private double agi;
	private double exp;
	private double res;
	private double health;
	
	public Item(double str, double agi, double exp, double res, double health) {
		this.str = str;
		this.agi = agi;
		this.exp = exp;
		this.res = res;
		this.health = health;
	}
	
	public double getStr() {
		return str;
	}
	
	public double getAgi() {
		return agi;
	}
	
	public double getExp() {
		return exp;
	}
	
	public double getRes() {
		return res;
	}
	
	public double getHealth() {
		return health;
	}

}
