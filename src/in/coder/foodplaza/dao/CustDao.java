package in.coder.foodplaza.dao;

import java.util.List;

import in.coder.foodplaza.pojo.Customer;
import in.coder.foodplaza.pojo.Food;

public interface CustDao {
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int id);
	Customer selectById(int id);
	List<Customer> selectAll();
}
