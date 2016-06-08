package config;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import geneticAlgorithm.item.Item;
import geneticAlgorithm.item.ItemsProvider;

public class ItemParser {

	public static ItemsProvider parseItems(String fileName) {
		List<Item> items = new LinkedList<>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			// Skip first line, it doesn't have significant values.
			scanner.nextLine();
			while (scanner.hasNext()) {
				Scanner lineScanner = new Scanner(scanner.nextLine());
				// Should we use the id?
				int id = lineScanner.nextInt();
				double str = lineScanner.nextDouble();
				double agi = lineScanner.nextDouble();
				double exp = lineScanner.nextDouble();
				double res = lineScanner.nextDouble();
				double health = lineScanner.nextDouble();
				items.add(new Item(str, agi, exp, res, health));
				lineScanner.close();
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ItemsProvider(items);
	}
}
