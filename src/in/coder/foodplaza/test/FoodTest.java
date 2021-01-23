package in.coder.foodplaza.test;

import java.util.List;
import java.util.Scanner;
import in.coder.foodplaza.dao.*;
import in.coder.foodplaza.pojo.Food;

public class FoodTest {

	public static void main(String[] args) {
		
		int foodid;
		String foodname,foodtype;
		double foodprice;
		boolean flag;
		
		Food food=null;
		
		FoodDaoImpl foodimpl=new FoodDaoImpl();
		
		int choice;
		while(true){
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Add food");
		System.out.println("2. update food");
		System.out.println("3.Delet food");
		System.out.println("4.Select by id");
		System.out.println("5.Select All");
		System.out.println("Enter the operation:");
		choice=sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter Food details:");
			foodname=sc.next();
			foodtype=sc.next();
			foodprice=sc.nextDouble();
			
			food=new Food();
			
			food.setFoodname(foodname);
			food.setFoodtype(foodtype);
			food.setFoodprice(foodprice);
			
			flag=foodimpl.addFood(food);
			
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
			System.out.println("Enter food id to update:");
			foodid=sc.nextInt();
			foodname=sc.next();
			foodtype=sc.next();
			foodprice=sc.nextDouble();
			food=new Food();
			
			food.setFoodid(foodid);
			food.setFoodname(foodname);
			food.setFoodtype(foodtype);
			food.setFoodprice(foodprice);
			
			flag=foodimpl.updateFood(food);
			
			if(flag ==true)
			{
				System.out.println("updated");
			}
			else
			{
				System.out.println("not updated");
			}
			
			
			break;
			
		case 3:
			System.out.println("Enter food id to delete:");
			foodid=sc.nextInt();
			
			
			flag=foodimpl.deleteFood(foodid);
			
			if(flag ==true)
			{
				System.out.println("deleted");
			}
			else
			{
				System.out.println("not deleted");
			}
			
			
			break;
			
			
		case 4:
			System.out.println("Enter food id to select:");
			foodid=sc.nextInt();
			
			food=foodimpl.selectById(foodid);
		
			
			if(food !=null)
			{
				System.out.println(food);
			}
			else
			{
				System.out.println("food not found");
			}
			
			
			break;
			
		case 5:
			
			List<Food> ls=foodimpl.selectAll();
		
			for(Food food2:ls)
			{
				System.out.println(food2);
			}
			break;
			default:
				System.exit(0);
		}
	}

}
}