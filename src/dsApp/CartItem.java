package dsApp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;

public class CartItem extends ShoppingItem{
	
	private SimpleIntegerProperty amt;
	private Double initialPrice;

	public CartItem(ShoppingItem g,int amt) {
		super(g.getRawPic(),g.getName(),g.getPrice(),g.getCategory(),g.getDescription());
		initialPrice = this.price.get();
		this.price.set(price.get()*amt);
		this.amt = new SimpleIntegerProperty(amt);
	}
	/**
	 * add 1 to item size
	 */
	public void addItem() {
		amt.set(getAmt() + 1);
	}
	/**
	 * subtract 1 from item size
	 */
	public void subItem() {
		amt.subtract(1);
	}
	
	@Override
	public Double getPrice() {
		price.set(initialPrice*amt.get());
		return price.get();
	}
	public String getName() {
		return name.get();
	}
	
	/** 
	 *  change the amt of this cart item
	 * @param i
	 */
	public void setAmt(int i) {
		amt.set(i);
	}
	
	public int getAmt() {
		return amt.get();
	}
	/**
	 * 
	 * @param ShoppingItem 
	 * @return true if that are the same type of shopping item
	 */
	public boolean equals(ShoppingItem c) {
		if(this.name.get().equals(c.getName())) {
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
