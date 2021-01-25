package DAO;

import java.util.List;

import POJO.Customer;

public interface CustDao {
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int id);
	Customer selectById(int id);
	List<Customer> selectAll();
}
