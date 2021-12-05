package dsApp;

import jxl.Cell;
import jxl.CellType;
import jxl.Image;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Storage 
{
	
	private final static String excelFile_location = "data/Grocery_Items.xls";;
	private static ObservableList<ShoppingItem> items_arraylist;
	
	
	/**
	 * Default constructor to setup a storage object using the default file name of our projects .xsl file name
	 */
	public Storage()
	{
		initialize();
	}
	
	/**
	 * gather all info of the shoppingitems form excel
	 */
	public static void initialize() {
		items_arraylist = FXCollections.observableArrayList();
		Workbook workbook = null;
		try {

            workbook = Workbook.getWorkbook(new File(excelFile_location));

            Sheet sheet = workbook.getSheet(0);
            int r = 0;
            while(!(sheet.getCell(1, r)).getType().equals(CellType.EMPTY))
            {
            	
            	Image image = sheet.getDrawing(r);
				byte[] picture = image.getImageData();
				String name = sheet.getCell(1, r).getContents();
				Double price = Double.parseDouble(sheet.getCell(2, r).getContents());
				String category = sheet.getCell(3, r).getContents();
				String description = sheet.getCell(4, r).getContents();
            	
            	items_arraylist.add(new ShoppingItem(picture, name, price, category, description));
            	
            	r++;
            	
            }//1st for loop
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) 
            {
                workbook.close();
            }//if

        }//finally
	}
	
	/**
	 * add all names of shopping item to a list of strings
	 * @param viewable
	 */
	public void setup(ObservableList<String> viewable)
	{
		for(ShoppingItem g: items_arraylist) {
			viewable.add(g.getName());
		}
	}//setup
	/**
	 * 
	 * @return the list of ShoppingItem
	 */
	public static ObservableList<ShoppingItem> getAllShoppingItems() {
		return items_arraylist;
	}
	
	/**
	 * 
	 * @return the list of all ShoppingItems names 
	 */
	public ObservableList<String> getAllItemsNames() {
		ObservableList<String> result = FXCollections.observableArrayList();
		for(ShoppingItem g: items_arraylist) {
			result.add(g.getName());
		}
		return result;
	}
	/**
	 * 
	 * @param Item name of the grocery item
	 * @return the Shopping item correlation to the name
	 */
	public ShoppingItem getItemFromString(String Item) {
		//System.out.println(items_arraylist);
		for(ShoppingItem g: items_arraylist) {
			if(g.getName().equals(Item)) {
				//System.out.println(g);
				return g;
			}
		}
		
		return null;
	}
	/**
	 * 
	 * @return the shoppingItem in array form
	 */
	public static ShoppingItem[] getArray()
	{
		ShoppingItem[] items = new ShoppingItem[items_arraylist.size()];
		
		for(int x = 0;x < items.length; x++)
		{
			items[x] = (ShoppingItem) items_arraylist.get(x);
		}
		
		return items;
	}
}//class
