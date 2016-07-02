package geneticAlgorithm.endCondition;

import config.Param;
import geneticAlgorithm.Population;

public enum EndConditionType {

	GENERATIONS(new MaxGenerationCondition()),
	CONTENT(new ContentCondition()),
	STRUCTURE(new StructureCondition()), 
	MAX_FITNESS(new MaxFitnessCondition());
	
	private EndCondition endCondition;
	
	EndConditionType(EndCondition endCondition){
		this.endCondition = endCondition;
	}
	
	public boolean finish(Param param, Population population){
		return endCondition.finish(param, population);
	}
	
	public void clear(){
		endCondition.clear();
	}
	
}
