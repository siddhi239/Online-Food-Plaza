package in.coder.foodplaza.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import in.coder.foodplaza.dao.CartDaoImpl;
import in.coder.foodplaza.dao.CustDaoImpl;
import in.coder.foodplaza.pojo.Cart;
import in.coder.foodplaza.pojo.Customer;

public class CartTest {

	public static void main(String[] args) {
		int cartid;
		String email;
		int foodid;
		int foodquantity;
		
		
		
Cart cart=null;
		

		CartDaoImpl cartimpl=new CartDaoImpl();
		boolean flag;
		int choice;
		while(true){
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Add cart");
		System.out.println("2. delete cart");
		System.out.println("3.Display cart");
		System.out.println("Enter the operation:");
		choice=sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter cart details:");
	
			email=sc.next();
			foodid=sc.nextInt();
			foodquantity=sc.nextInt();
			
			cart=new Cart();
			
			cart.setEmail(email);
			cart.setFoodid(foodid);
			cart.setFoodquantity(foodquantity);
			
			flag=cartimpl.add_to_cart(cart);
			
			if(flag ==true)
			{
				System.out.println("added");
			}
			else
			{
				System.out.println("not added");
			}
			break;
			
		case 2:
			

			System.out.println("Enter cart id to delete:");
			cartid=sc.nextInt();
			
			
			flag=cartimpl.deleteCart(cartid);
			
			if(flag ==true)
			{
				System.out.println("deleted");
			}
			else
			{
				System.out.println("not deleted");
			}
			
		
		break;
		
		case 3:
			System.out.println("Enter cust email:");
			email=sc.next();
			
			List<Cart> ls=cartimpl.display_cart(email);
			Iterator<Cart> i=ls.iterator();
			
			
			while(i.hasNext())
			{
				System.out.println(i.next());
			}
		break;
		
		default:
			System.exit(0);
	
		
		}
		}
	}

}
