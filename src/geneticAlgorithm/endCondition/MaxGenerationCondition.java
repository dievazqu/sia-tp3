package geneticAlgorithm.endCondition;

import config.Param;
import geneticAlgorithm.Population;

public class MaxGenerationCondition implements EndCondition {

	@Override
	public boolean finish(Param param, Population population) {
		return population.getGeneration() >= param.getMaxGeneration();
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
