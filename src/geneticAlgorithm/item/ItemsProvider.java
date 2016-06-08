package geneticAlgorithm.item;

import java.util.List;

public class ItemsProvider {

	List<Item> items;
	
	public ItemsProvider(List<Item> list) {
		items = list;
	}
	
	public Item getItemAt(int index) {
		return items.get(index);
	}
	
	public int getRandomIndex() {
		return (int) (Math.random() * items.size());
	}
	
}
