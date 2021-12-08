package dsApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
/**
 * 
 * @author Manyeuris Soriano
 *
 */
public class FilterController {
	private static final String[] Attributes = { "Lowest to Highest", "Highest to Lowest", "Fruit", "Vegetables",
			"Meat & Seafood", "Dairy", "Breakfast", "Snacks", "Breads" };

	public FilterController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * creates Liss tof checkboxes
	 * @param viewable
	 */
	public static void setup(ObservableList<CheckBox> viewable) {
		for (int i = 0; i < Attributes.length; i++) {
			viewable.add(new CheckBox(Attributes[i]));
			viewable.get(i).setMouseTransparent(true);
		}
	}
	/**
	 * 
	 * @param filters - the attributes that we want to filter out
	 * @param items - the list of items that need to be filters
	 */
	public static void filterItems(ArrayList<String> filters, ObservableList<ShoppingItem> items) {
		ObservableList<ShoppingItem> newList = FXCollections.observableArrayList();
		for (int i = 0; i < filters.size(); i++) {
			String filter = filters.get(i);
			//usimng the collections.sort to organize lowest to highest
			if (filter.equals(Attributes[0])) {
				Collections.sort(items, new Comparator<ShoppingItem>() {

					@Override
					public int compare(ShoppingItem o1, ShoppingItem o2) {
						Double a = o1.getPrice();
						Double b = o2.getPrice();
						return Integer.valueOf(a.compareTo(b));
					}
				});
			} else if (filter.equals(Attributes[1])) {
				Collections.sort(items, new Comparator<ShoppingItem>() {
					@Override
					public int compare(ShoppingItem o1, ShoppingItem o2) {
						Double a = o1.getPrice();
						Double b = o2.getPrice();
						return Integer.valueOf(b.compareTo(a));
					}

				});
			} else {
				// add items if has certain attribute
				for (ShoppingItem g : items) {
					if (g.getCategory().equals(filter)) {
						newList.add(g);
					}
				}

				if (i == filters.size() - 1) {// if there are more filters left d not set the list to be the new items
					items.setAll(newList);
				}

			}

		}
	}
	/**
	 * 
	 * @param viewable list of filters
	 * @return a list of checked off filters
	 */
	public static ArrayList<CheckBox> allCheckFilters(ObservableList<CheckBox> viewable) {
		ArrayList<CheckBox> checkedBoxes = new ArrayList<>();
		for (CheckBox c : viewable) {
			if (c.isSelected()) {
				checkedBoxes.add(c);

			}
		}
		return checkedBoxes;
	}
}
