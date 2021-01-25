package DAO;

import java.util.List;

import POJO.Cart;

public interface CartDao {
	boolean add_to_cart(Cart cart);
	boolean deleteCart(int cartid);
	List<Cart> display_cart(String email);
	boolean clearcart(String email);
	boolean isFoodinCart(int FoodId,String email);
}
