package dsApp;

//imports
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;


/**
 * an object which acts as a shopping item. It has a name, price, category, description, and even images.
 * @author Nicholas LoPilato
 *
 */
public class ShoppingItem
{

	protected Queue<byte[]> picsAll;
	protected byte[] picture;
	protected SimpleStringProperty name;
	protected SimpleDoubleProperty price;
	protected String category;
	protected String description;
	
	
	/**
	 * constructor to make a shopping item with multiple pictures
	 * @param pictures Queue of byte[]'s of the pictures for this shopping item
	 * @param name name of this shopping item
	 * @param price price of this shopping item
	 * @param category category of this shopping item
	 * @param description description of this shopping item
	 */
	public ShoppingItem(Queue<byte[]> pictures, String name, Double price, String category, String description)
	{
		this.picsAll = pictures;
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		this.category = category;
		this.description = description;
		
		this.picture = pictures.getHeadContents();
	}
	
	/**
	 * constructor to make a shopping item with one picture
	 * @param picture byte[] for the image of this shopping item
	 * @param name name of this shopping item
	 * @param price price of this shopping item
	 * @param category category of this shopping item
	 * @param description description of this shopping item
	 */
	public ShoppingItem(byte[] picture, String name, Double price, String category, String description)
	{
		this.picture = picture;
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		this.category = category;
		this.description = description;
		
		this.picsAll = new Queue();
		this.picsAll.enqueue(picture);
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
		this.picsAll = new Queue();
		this.picture = null;
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		this.category = category;
		this.description = description;
	}
	
	/**
	 * method to get the javafx Image version of this ShoppingItem's first picture
	 * @return the javafx Image of the first picture in the queue
	 */
	public Image getPic()
	{
		InputStream inStream = new ByteArrayInputStream(picture);
		Image image = new Image(inStream);
		return image;
	}
	
	/**
	 * method to get the first picture in it's raw form as a byte[]
	 * @return the byte[] version of the first picture
	 */
	public byte[] getRawPic() {
		return picture;
	}
	
	/**
	 * turns everything from the picsAll Queue into javafx Images and enqueues them to a new Queue which is returned
	 * 
	 * How it works:
	 * create a copy of this ShoppingItem's Queue of byte[] of their pictures
	 * loop through the copy until it is empty
	 * 	during which it dequeues the items from thecopy and turns them into a javafx Image
	 * 	after that the javafx Image is enqueued to the Queue of javafx Image
	 * the Queue of javafx Image is then returned at the end
	 * 
	 * @return Queue of javafx images of this ShoppingItem
	 */
	public Queue<Image> getPics()
	{
		Queue<byte[]> tempCopy = new Queue<byte[]>(getRawPics());
		Queue<Image> images = new Queue();
		
		while(!tempCopy.isEmpty())
		{
			byte[] currentImg = tempCopy.dequeue();
			InputStream inStream = new ByteArrayInputStream(currentImg);
			Image image = new Image(inStream);
			images.enqueue(image);	
		}
		return images;
	}
	
	public Queue<byte[]> getRawPics()
	{
		return picsAll;
	}
	
	/**
	 * method to get the next image in the queue from this item
	 * it changes the actual queue of this item as well
	 * @return javafx Image of the next image in queue
	 */
	public Image getNextPic()
	{
		Queue<Image> images = getPics();
		Image img = getPics().dequeue();
		
		this.picsAll.enqueue(this.picsAll.dequeue());
		
		return img;
		
	}
	
	/**
	 * getter method for the name
	 * @return name of this shopping item
	 */
	public String getName()
	{
		return name.get();
	}
	
	/**
	 * getter method for the price
	 * @return price of this shopping item
	 */
	public Double getPrice()
	{
		return price.get();
	}
	
	/**
	 * getter method for the category
	 * @return category of this shopping item
	 */
	public String getCategory()
	{
		return category;
	}
	
	/**
	 * getter method for the description
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
//	private String picturesToString()
//	{
//		String fin = "";
//		
//		for(File picture: pictures)
//		{
//			fin += "Image" + (pictures.indexOf(picture) + 1) + ": " + picture.toString();
//		}
//		
//		return fin;
//	}
	
	/**
	 * creates a string containing the name, price, category, description, and pictures of this shopping item
	 * @return string version of this shopping item
	 */
	public String toString()
	{
//		if(pictures.size() > 1)
//		{
//			return "\n" + name + " " + price + " " + category + " " + description + " | " + picturesToString();
//		}
//		else
//			return "\n" + name + " " + price + " " + category + " " + description + " Image: " + picture.toString();//yes i realize that this isn't really needed, but i left it anyway
		return String.format("%s : %.2f", getName(),getPrice());
	
	}

	
}
