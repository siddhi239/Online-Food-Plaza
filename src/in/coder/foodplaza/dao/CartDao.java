package in.coder.foodplaza.dao;

import java.util.List;

import in.coder.foodplaza.pojo.Cart;

public interface CartDao {
	boolean add_to_cart(Cart cart);
	boolean deleteCart(int cartid);
	List<Cart> display_cart(String email);
	boolean clearcart(String email);
}
