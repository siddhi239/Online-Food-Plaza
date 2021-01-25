package POJO;

public class FoodOrder {
	private int orderid;
	private String email,orderdate;
	private double totalbill;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public double getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(double totalbill) {
		this.totalbill = totalbill;
	}
	@Override
	public String toString() {
		return "FoodOrder [orderid=" + orderid + ", email=" + email + ", orderdate=" + orderdate + ", totalbill="
				+ totalbill + "]";
	}
	
	}