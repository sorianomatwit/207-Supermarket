package dsApp;


import java.io.File;
import java.util.ArrayList;

public class ShoppingItem
{

	private ArrayList<File> pictures;
	private File picture;
	private String name;
	private Double price;
	private String category;
	private String description;
	
	
	/**
	 * constructor to make a shopping item with multiple pictures
	 * @param pictures ArrayList of Files of the pictures for this shopping item
	 * @param name name of this shopping item
	 * @param price price of this shopping item
	 * @param category category of this shopping item
	 * @param description description of this shopping item
	 */
	public ShoppingItem(ArrayList<File> pictures, String name, Double price, String category, String description)
	{
		this.pictures = pictures;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
		
		this.picture = pictures.get(0);
	}
	
	/**
	 * constructor to make a shopping item with one picture
	 * @param picture File for the image of this shopping item
	 * @param name name of this shopping item
	 * @param price price of this shopping item
	 * @param category category of this shopping item
	 * @param description description of this shopping item
	 */
	public ShoppingItem(File picture, String name, Double price, String category, String description)
	{
		this.picture = picture;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}
	/**
	 * constructor to make a shopping item without pictures
	 * @param name name of this shopping item
	 * @param price price of this shopping item
	 * @param category category of this shopping item
	 * @param description description of this shopping item
	 */
	public ShoppingItem(String name, Double price, String category, String description)
	{
		this.pictures = null;
		this.picture = null;
		this.name = name;
		this.price = price;
		this.category = category;
		this.description = description;
	}
	
	/**
	 * 
	 * @return the File type of 1st picture in the list of pictures
	 */
	public File getPic()
	{
		return picture;
	}
	
	/**
	 * 
	 * @param x the number of photo in the list of pictures
	 * @return the File type of the xth picture
	 */
	public File getPicAt(int x)
	{
		return pictures.get(x);
	}
	
	/**
	 * 
	 * @return ArrayList of File type for all the pictures for this shopping item
	 */
	public ArrayList<File> getPics()
	{
		return pictures;
	}
	
	/**
	 * 
	 * @return name of this shopping item
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return price of this shopping item
	 */
	public Double getPrice()
	{
		return price;
	}
	
	/**
	 * 
	 * @return category of this shopping item
	 */
	public String getCategory()
	{
		return category;
	}
	
	/**
	 * 
	 * @return description of this shopping item
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Method used to help in the toString() method. 
	 * It loops through the ArrayList pictures and adds the toString() for each of the individual pictures in the list.
	 * @return string version of all the pictures for this shopping item
	 */
	private String picturesToString()
	{
		String fin = "";
		
		for(File picture: pictures)
		{
			fin += "Image" + (pictures.indexOf(picture) + 1) + ": " + picture.toString();
		}
		
		return fin;
	}
	
	/**
	 * creates a string containing the name, price, category, description, and pictures of this shopping item
	 * @return string version of this shopping item
	 */
	public String toString()
	{
		if(pictures.size() > 1)
		{
			return "\n" + name + " " + price + " " + category + " " + description + " | " + picturesToString();
		}
		else
			return "\n" + name + " " + price + " " + category + " " + description + " Image: " + picture.toString();//yes i realize that this isn't really needed, but i left it anyway
	}

	
}
