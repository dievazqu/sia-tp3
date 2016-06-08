package geneticAlgorithm.individual;

import java.util.List;
import java.util.function.Function;

import geneticAlgorithm.allele.Allele;
import geneticAlgorithm.allele.HeightAllele;
import geneticAlgorithm.allele.ItemAllele;
import geneticAlgorithm.item.Item;

public abstract class Unit extends Individual {

	
	public Unit(List<Allele> alleles) {
		super(alleles);
	}
	
	@Override
	public double getFitnessValue() {
		return getAttackMultiplier() * getAttack() + getDefenseMultiplier() * getDefense();
	}
	
	public abstract double getAttackMultiplier();
	public abstract double getDefenseMultiplier();
	public abstract double getAgiMultiplier();
	public abstract double getStrMultiplier();
	public abstract double getResMultiplier();
	public abstract double getExpMultiplier();
	public abstract double getHPMultiplier();
	
	
	public double getAttack(){
		return (getAgi()+getExp())*getStr()*getATM();
	}
	
	public double getDefense(){
		return (getRes()+getExp())*getHP()*getDEM();
	}
	
	public double calculateSum(Function<Item, Double> f){
		double ans=0;
		for(Allele a: alleles.subList(1, alleles.size())){
			ans+=f.apply(((ItemAllele)a).getItem());
		}
		return ans;
	}
	
	public double getAgi(){
		return Math.tanh(0.01*getAgiMultiplier()*calculateSum(i->i.getAgi()));
	}
	
	public double getExp(){
		return 0.6*Math.tanh(0.01*getExpMultiplier()*calculateSum(i->i.getExp()));
	}
	
	public double getRes(){
		return Math.tanh(0.01*getResMultiplier()*calculateSum(i->i.getRes()));
	}
	
	public double getStr(){
		return 100*Math.tanh(0.01*getStrMultiplier()*calculateSum(i->i.getStr()));
	}
	
	public double getHP(){
		return 100*Math.tanh(0.01*getHPMultiplier()*calculateSum(i->i.getHealth()));
	}
	
	public double getATM(){
		return ((HeightAllele)alleles.get(0)).getAttackModifier();
	}
	
	public double getDEM(){
		return ((HeightAllele)alleles.get(0)).getDefenseModifier();
	}
}
