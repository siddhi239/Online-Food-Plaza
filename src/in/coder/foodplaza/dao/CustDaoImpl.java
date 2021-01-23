package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.foodplaza.pojo.Customer;
import in.coder.foodplaza.pojo.Food;
import in.coder.foodplaza.utility.DBConnection;

public class CustDaoImpl implements CustDao{


	Connection con=null;
	
	PreparedStatement ps=null;
	
	ResultSet rs=null;
	
	String query=null;
	
	
	public boolean addCustomer(Customer customer) {
con= DBConnection.getConnection();
		
		query="insert into Customer21766 (name,email,contact,address,password) values(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, customer.getName());
			ps.setString(2,customer.getEmail());
			ps.setLong(3, customer.getContact());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getPassword());
			
			int row=ps.executeUpdate();
			
			if(row >0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	public boolean updateCustomer(Customer customer) {
		con= DBConnection.getConnection();
		
		query="update Customer21766 set name=?,email=?,contact=?,address=?,password=? where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(6, customer.getId());
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getContact());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getPassword());
			int row=ps.executeUpdate();
			
			if(row >0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
		
	public boolean deleteCustomer(int id){
		con= DBConnection.getConnection();
		query="delete from Customer21766 where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			
			
			int row=ps.executeUpdate();
			
			if(row >0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public Customer selectById(int id) {
		
con= DBConnection.getConnection();
		
		query="select * from Customer21766 where id=?";
		try {
			ps=con.prepareStatement(query);
			
			ps.setInt(1,id);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				Customer c=new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString(3));
				c.setContact(rs.getLong(4));
				c.setAddress(rs.getString(5));
				c.setPassword(rs.getString(6));
				return c;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		return null;
	}

	@Override
	public List<Customer> selectAll() {
con= DBConnection.getConnection();
		
		query="select * from Customer21766";
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
				List<Customer> ls=new ArrayList<Customer>();
				while(rs.next()){
					Customer c=new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString(3));
				c.setContact(rs.getLong(4));
				c.setAddress(rs.getString(5));
				c.setPassword(rs.getString(6));
				ls.add(c);
				}
				return ls;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
		
		return null;
	}
	
}
