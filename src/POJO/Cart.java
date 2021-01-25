package POJO;

public class Cart {
	private int cartid;
	private String email;
	private int foodid;
	private String foodname;
	private int foodquantity;
	public int getFoodquantity() {
		return foodquantity;
	}
	public void setFoodquantity(int foodquantity) {
		this.foodquantity = foodquantity;
	}
	private Double foodprice;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public Double getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(Double foodprice) {
		this.foodprice = foodprice;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", email=" + email + ", foodid=" + foodid + ", foodname=" + foodname
				+ ", foodquantity=" + foodquantity + ", foodprice=" + foodprice + "]";
	}
	
	
	
	
}
