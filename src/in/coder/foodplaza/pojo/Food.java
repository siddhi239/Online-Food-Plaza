package in.coder.foodplaza.pojo;

public class Food {
	private int foodid;
	private String foodname,foodtype;
	private double foodprice;
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
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public double getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}
	@Override
	public String toString() {
		return "Food [foodid=" + foodid + ", foodname=" + foodname + ", foodtype=" + foodtype + ", foodprice="
				+ foodprice + "]";
	}
	
	
}
