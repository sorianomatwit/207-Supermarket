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

public class TempTestingNew
{

	public static void main(String[] args)
	{
		
		ShoppingItem[] items = null;
		
		
		final String EXCEL_FILE_LOCATION = "data/GroceryItems.xls";
		Workbook workbook = null;
        try {

            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));

            Sheet sheet = workbook.getSheet(0);
            items = new ShoppingItem[3];
            
            System.out.println("Debug: sheet num of images - " + sheet.getNumberOfImages());
            for(int r = 0; r < 3;r++)
            {
            	File picture = null;
            	String name = null;
            	Double price = null;
            	String category = null;
            	String description = null;
            	for(int c = 0; c < 5; c++)
            	{
            		
            		switch(c)
            		{
            		case 0://i dont think this works properly but im going to leave it for now
            			if(r == 0)
            				picture = null;
            			else
            			{
            				Image image = sheet.getDrawing(r - 1);
            				picture = image.getImageFile();
            				System.out.println(r + ":Debug: image col - " + image.getColumn() + " row - " + image.getRow());
            			}
            			
            			break;
            		case 1:
            			name = sheet.getCell(c, r).getContents();
            			break;
            		case 2:
            			if(r == 0)
            				price = null;
            			else	
            				price = Double.parseDouble(sheet.getCell(c, r).getContents());
            			break;
            		case 3:
            			category = sheet.getCell(c, r).getContents();
            			break;
            		case 4:
            			description = sheet.getCell(c, r).getContents();
            			break;
            		default:
            			System.out.println("Bug: default case reaeched");
            			break;
            		}//switch
            		
            	}//2nd for loop
            	
            	items[r] = new ShoppingItem(picture, name, price, category, description);
            	
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
        
        //testing outputs
        for(int x = 0; x < items.length; x++)
        {
        	System.out.println(items[x].toString());
        }
        
	}//main

}//class
