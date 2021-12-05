package dsApp;

import javafx.collections.ObservableList;

public class CartItem extends ShoppingItem{
	
	private int amtOfitem = 1;
	private Double initialPrice;

	public CartItem(ShoppingItem g,int amt) {
		super(g.getRawPic(),g.getName(),g.getPrice(),g.getCategory(),g.getDescription());
		initialPrice = this.price;
		this.price = price*amt;
		amtOfitem = amt;
	}
	/**
	 * add 1 to item size
	 */
	public void addItem() {
		amtOfitem++;
	}
	/**
	 * subtract 1 from item size
	 */
	public void subItem() {
		amtOfitem--;
	}
	
	@Override
	public Double getPrice() {
		price = initialPrice*amtOfitem;
		return price;
	}
	public String getName() {
		if(amtOfitem > 1) {
			return name + String.format(": %d",amtOfitem);
		}
		return name;
	}
	
	/** 
	 *  change the amt of this cart item
	 * @param i
	 */
	public void setAmt(int i) {
		amtOfitem = 1;
	}
	/**
	 * 
	 * @param ShoppingItem 
	 * @return true if that are the same type of shopping item
	 */
	public boolean equals(ShoppingItem c) {
		if(this.name.equals(c.getName())) {
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param list of cartitems groceries 
	 * @return total price
	 */
	public static Double calcTotal(ObservableList<CartItem> groceries) {
		Double total = 0.0;
		for(CartItem g: groceries) {
			total += g.getPrice();
		}
		return total;
	}
}
