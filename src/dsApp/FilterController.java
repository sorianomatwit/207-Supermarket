package dsApp;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

public class FilterController{
	private static final String[] Attributes = {"Lowest to Highest","Highest to Lowest","Fruit","Vegetables",
			"Meat & Seafood",
			"Dairy",
			"Breakfast",
			"Snacks",
			"Breads"
};
	public FilterController() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setup(ObservableList<CheckBox> viewable) {
		for(int i = 0; i < Attributes.length;i++) {
			viewable.add(new CheckBox(Attributes[i]));
		}
	}
	
	
	public static ArrayList<CheckBox> checkFilters(ObservableList<CheckBox> viewable) {
		ArrayList<CheckBox> checkedBoxes = new ArrayList(); 
		for(CheckBox c: viewable) {
			if(c.isSelected()) {
				checkedBoxes.add(c);
				
			}
		}
		return checkedBoxes;
	}
}
