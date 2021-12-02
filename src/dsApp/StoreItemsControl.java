package dsApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class StoreItemsControl {
	private static ArrayList<ShoppingItem> Item = new ArrayList<>();
	
	public StoreItemsControl(ObservableList<String> Viewable) {
		
	}

	private void addItem(ObservableList<String> Viewable, ShoppingItem g) {
		Viewable.add(g.getName());
	}
	
	@SuppressWarnings("deprecation")
	private void getItemsFromFile() {
		String fileLocation = "./data/Grocery_Items.xls";
		
		try {
			FileInputStream fis = new FileInputStream(new File(fileLocation));
			
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			
			HSSFSheet sheet = wb.getSheetAt(0);
			
			for(Row r: sheet) {
				Item.add(new ShoppingItem(,r.getCell(1).getStringCellValue(),r.getCell(2).getStringCellValue(),
						r.getCell(3).getStringCellValue(),r.getCell(4).getStringCellValue()));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
