package geneticAlgorithm.item;

import java.util.List;

import util.RandomUtil;

public class ItemsProvider {

	List<Item> items;
	
	public ItemsProvider(List<Item> list) {
		items = list;
	}
	
	public Item getItemAt(int index) {
		return items.get(index);
	}
	
	public int getRandomIndex() {
		return (int) (RandomUtil.getRandom(0, items.size()));
	}
	
}
