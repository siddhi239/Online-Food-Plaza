package in.coder.foodplaza.test;

import java.util.Scanner;

import in.coder.foodplaza.dao.CartDaoImpl;
import in.coder.foodplaza.dao.FoodOrderDaoImpl;
import in.coder.foodplaza.pojo.FoodOrder;

public class FoodOrderTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int oid;
		String email;
		FoodOrder fd= new FoodOrder();
		FoodOrderDaoImpl fdl=new FoodOrderDaoImpl();
		System.out.println("Enter Customer Email:");
		email=sc.next();
		oid=fdl.Placeorder(email);
		System.out.println("OrderId:"+oid);
		CartDaoImpl cd=new CartDaoImpl();
		cd.clearcart(email);
	}

}
