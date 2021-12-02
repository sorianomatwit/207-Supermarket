package dsApp;


import java.io.File;

import org.apache.poi.ss.usermodel.Cell;

public class ShoppingItem
{
	
	private Cell picture;
	
	private String name;
	private Double price;
	private String category;
	private String description;
	
	
	
	public ShoppingItem(Cell picture, String name, Double price, String category, String description)
	{
		this.picture = picture;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}
	
	public ShoppingItem(String name, Double price, String category, String description)
	{
		this.picture = null;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}
	
	
	public File getPic()
	{
		//return file in picture cell
		
		return null;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Double getPrice()
	{
		return price;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	
	public String toString()
	{
		return "\n" + name + " " + price + " " + category + " " + description + " Image: " + picture.toString();
	}

	
}
