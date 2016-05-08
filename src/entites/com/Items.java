package entites.com;

 

public class Items {
	
	private Product product=new  Product();
	
	private int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Items(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Items() {
		super();
	}
	
	

}
