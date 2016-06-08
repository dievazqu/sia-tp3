package geneticAlgorithm.allele;

import geneticAlgorithm.item.Item;
import geneticAlgorithm.item.ItemsProvider;

public class ItemAllele extends Allele {

	private ItemsProvider itemProvider;
	private int characteristicIndex;
	
	public ItemAllele(ItemsProvider itemProvider, int characteristicIndex) {
		this.itemProvider = itemProvider;
		this.characteristicIndex = characteristicIndex;
	}

	@Override
	public Allele clone() {
		return new ItemAllele(itemProvider, characteristicIndex);
	}

	@Override
	public void mutate() {
		characteristicIndex = itemProvider.getRandomIndex();
	}

	@Override
	public String toString() {
		Item item = getItem();
		return "ItemAllele ["
				+ "str=" + String.format("%.2f", item.getStr()) + ", "
				+ "agi=" + String.format("%.2f", item.getAgi()) + ", "
				+ "exp=" + String.format("%.2f", item.getExp()) + ", "
				+ "res=" + String.format("%.2f", item.getRes()) + ", "
				+ "health=" + String.format("%.2f", item.getHealth()) + "]";
	}
	
	public Item getItem(){
		return itemProvider.getItemAt(characteristicIndex);
	}

}
