package dsApp;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

public class FilterController{
	private static final String[] Attributes = {"Lowest to Highest","Highest to Lowest","Fruit","Vegetables",
			"Meat & Seafood",
			"Dairy",
			"Breakfast",
			"Snacks",
			"Bakery and Breads"
};
	public FilterController() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setup(ObservableList<CheckBox> viewable) {
		for(int i = 0; i < Attributes.length;i++) {
			viewable.add(new CheckBox(Attributes[i]));
		}
	}
	
	public static void checkFilters(ObservableList<CheckBox> viewable) {
		for(CheckBox c: viewable) {
			
		}
	}
}
