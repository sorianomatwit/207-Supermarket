package dsApp;

public class CartItem extends ShoppingItem{
	
	private int amtOfitem = 1;
	private Double initialPrice;
	public CartItem(String name, Double price, String category, String description,int amt) {
		super(name,price,category,description);
		initialPrice = this.price;
		this.price = price*amt;
		amtOfitem = amt;
	}
	
	public CartItem(ShoppingItem g,int amt) {
		super(g.getName(),g.getPrice(),g.getCategory(),g.getDescription());
		initialPrice = this.price;
		this.price = price*amt;
		amtOfitem = amt;
	}
	
	public void addItem() {
		amtOfitem++;
	}
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
			return name + String.format(" x%d",amtOfitem);
		}
		return name;
	}
	
	
	public boolean equals(CartItem c) {
		if(this.name.equals(c.getName())) {
			return true;
		}
		return false;
		
	}
}
