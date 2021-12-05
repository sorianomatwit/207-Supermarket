package dsApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

public class FilterController {
	private static final String[] Attributes = { "Lowest to Highest", "Highest to Lowest", "Fruit", "Vegetables",
			"Meat & Seafood", "Dairy", "Breakfast", "Snacks", "Breads" };

	public FilterController() {
		// TODO Auto-generated constructor stub
	}

	public static void setup(ObservableList<CheckBox> viewable) {
		for (int i = 0; i < Attributes.length; i++) {
			viewable.add(new CheckBox(Attributes[i]));
			viewable.get(i).setMouseTransparent(true);
		}
	}

	public static void filterItems(String filter, ObservableList<String> items, Storage food) {
		if (filter.equals(Attributes[0])) {
			Collections.sort(items, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					Double a = food.getItemFromString(o1).getPrice();
					Double b = food.getItemFromString(o2).getPrice();
					return Integer.valueOf(a.compareTo(b));
				}

			});
		} else if (filter.equals(Attributes[1])) {
			Collections.sort(items, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					Double a = food.getItemFromString(o1).getPrice();
					Double b = food.getItemFromString(o2).getPrice();
					return Integer.valueOf(b.compareTo(a));
				}

			});
		} else {
			ObservableList<String> newList = FXCollections.observableArrayList();
			for (String s : items) {
				ShoppingItem g = food.getItemFromString(s);
				if (g.getCategory().equals(filter)) {
					newList.add(s);
				}
			}
			items.setAll(newList);
		}
	}


	public static ArrayList<CheckBox> allCheckFilters(ObservableList<CheckBox> viewable) {
		ArrayList<CheckBox> checkedBoxes = new ArrayList();
		for (CheckBox c : viewable) {
			if (c.isSelected()) {
				checkedBoxes.add(c);

			}
		}
		return checkedBoxes;
	}
}
