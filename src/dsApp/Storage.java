package dsApp;

import jxl.Cell;
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

import javafx.collections.ObservableList;

public class Storage
{
	
	private final static String excelFile_location = "data/Grocery_Items.xls";;
	private static ArrayList<ShoppingItem> items_arraylist;
	
	
	/**
	 * Default constructor to setup a storage object using the default file name of our projects .xsl file name
	 */
	public Storage()
	{
	}
	
	
	
	public static void setup(ObservableList<String> viewable)
	{
		items_arraylist = new ArrayList<>();
		Workbook workbook = null;
		try {

            workbook = Workbook.getWorkbook(new File(excelFile_location));

            Sheet sheet = workbook.getSheet(0);
            
            for(int r = 0; r < 5;r++)
            {
            	
            	Image image = sheet.getDrawing(r);
				File picture = image.getImageFile();
				String name = sheet.getCell(1, r).getContents();
				Double price = Double.parseDouble(sheet.getCell(2, r).getContents());
				String category = sheet.getCell(3, r).getContents();
				String description = sheet.getCell(4, r).getContents();
            	
            	items_arraylist.add(new ShoppingItem(picture, name, price, category, description));
            	
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
		for(ShoppingItem g: items_arraylist) {
			viewable.add(g.getName());
		}
	}//setup

	public ShoppingItem[] getArray()
	{
		ShoppingItem[] items = new ShoppingItem[items_arraylist.size()];
		
		for(int x = 0;x < items.length; x++)
		{
			items[x] = (ShoppingItem) items_arraylist.get(x);
		}
		
		return items;
		
	}
}//class
