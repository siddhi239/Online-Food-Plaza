package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Cart;
import UTILITY.DBConnection;

public class CartDaoImpl implements CartDao{
Connection con=null;
	
	PreparedStatement ps=null;
	
	ResultSet rs=null;
	
	String query=null;
	
	
	public boolean add_to_cart(Cart cart) {
		con= DBConnection.getConnection();
				
				query="insert into cart(custemail,foodid,foodquantity) values(?,?,?)";
				try {
					ps=con.prepareStatement(query);
					
					
					ps.setString(1,cart.getEmail());
					ps.setInt(2, cart.getFoodid());
					ps.setInt(3, cart.getFoodquantity());
					
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
	public boolean deleteCart(int cartid){
		con= DBConnection.getConnection();
		query="delete from cart where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, cartid);
			
			
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

	public List<Cart> display_cart(String email)
	{
		con= DBConnection.getConnection();
		query="select c.id,f.foodname,f.foodprice,c.foodquantity from food21766 as f inner join cart as c on f.foodid=c.foodid where custemail=?";
		
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,email);

			rs=ps.executeQuery();
			
				List<Cart> ls=new ArrayList<>();
				while(rs.next()){
					Cart c=new Cart();
				c.setCartid(rs.getInt(1));
				
				c.setFoodname(rs.getString(2));
				c.setFoodprice(rs.getDouble(3));
				c.setFoodquantity(rs.getInt(4));
				ls.add(c);
				}
				return ls;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	
	@Override
	public boolean clearcart(String email)
	{
		int rows=0;
	try(Connection conn= DBConnection.getConnection())
	{
		
			query="delete from cart where custemail=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, email);
			rows=ps.executeUpdate();
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	if(rows>0)
		return true;
	else
		return false;
	}
	@Override
	public boolean isFoodinCart(int FoodId, String email) {
		try {
			Connection conn=DBConnection.getConnection();
			query="select * from cart where foodid=? and custemail=?";
			ps=conn.prepareStatement(query);
			ps.setString(2, email);
			ps.setInt(1, FoodId);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
