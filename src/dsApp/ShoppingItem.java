
import java.awt.Image;
import java.io.File;

public class ShoppingItem
{
	
	private File picture;
	
	private String name;
	private Double price;
	private String category;
	private String description;
	
	
	
	public ShoppingItem(File picture, String name, Double price, String category, String description)
	{
		this.picture = picture;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}
	
	public File getPic()
	{
		return picture;
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