package in.coder.foodplaza.test;

import java.util.List;
import java.util.Scanner;

import in.coder.foodplaza.dao.CustDaoImpl;
import in.coder.foodplaza.dao.FoodDaoImpl;
import in.coder.foodplaza.pojo.Customer;
import in.coder.foodplaza.pojo.Food;

public class CustomerTest {

	public static void main(String[] args) {
		int id;
		String name,email;
		long contact;
		String address;
		
		Customer customer=null;
		

		CustDaoImpl custimpl=new CustDaoImpl();
		boolean flag;
		int choice;
		while(true){
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Add customer");
		System.out.println("2. update customer");
		System.out.println("3.Delet customer");
		System.out.println("4.Select by id");
		System.out.println("5.Select All");
		System.out.println("Enter the operation:");
		choice=sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter customer details:");
			name=sc.next();
			email=sc.next();
			contact=sc.nextLong();
			address=sc.next();
			
			customer=new Customer();
			
			customer.setName(name);
			customer.setEmail(email);
			customer.setContact(contact);
			customer.setAddress(address);
			
			flag=custimpl.addCustomer(customer);
			
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
			System.out.println("Enter customer id to update:");
			id=sc.nextInt();
			name=sc.next();
			email=sc.next();
			contact=sc.nextLong();
			address=sc.next();
			customer=new Customer();
			
			customer.setId(id);
			customer.setName(name);
			customer.setEmail(email);
			customer.setContact(contact);
			customer.setAddress(address);
			flag=custimpl.updateCustomer(customer);
			
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
			
			System.out.println("Enter customer id to delete:");
			id=sc.nextInt();
			
			
			flag=custimpl.deleteCustomer(id);
			
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
			
			System.out.println("Enter customer id to select:");
			id=sc.nextInt();
			
			customer=custimpl.selectById(id);
		
			
			if(customer !=null)
			{
				System.out.println(customer);
			}
			else
			{
				System.out.println("customer not found");
			}
			 break;

		
case 5:
			
			List<Customer> ls=custimpl.selectAll();
		
			for(Customer Customer2:ls)
			{
				System.out.println(Customer2);
			}
			break;
			default:
				System.exit(0);
		
		
		}
		
	}

	}
	}
