package geneticAlgorithm.mutation;

import java.util.List;

import geneticAlgorithm.allele.Allele;
import util.RandomUtil;

public enum MutationType {
	CLASSIC, 
	NOUNIFORM;

	public void mutate(List<Allele> alleles, double probability) {
		switch (this) {
		case CLASSIC:
			if (RandomUtil.getRandom() < probability) {
				alleles.get(RandomUtil.getRandom(alleles.size())).mutate();
			}
			break;
		case NOUNIFORM:
			for (Allele a : alleles) {
				if (RandomUtil.getRandom() < probability)
					a.mutate();
			}
			break;
		}
	}
}
