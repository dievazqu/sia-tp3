package geneticAlgorithm.endCondition;

import config.Param;
import geneticAlgorithm.Population;

public interface EndCondition {

	boolean finish(Param param, Population population);
	
	void clear();
}
