package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.coder.foodplaza.pojo.Cart;
import in.coder.foodplaza.pojo.Customer;
import in.coder.foodplaza.utility.DBConnection;

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
		query="select c.id,c.custemail,f.foodname,f.foodprice,c.foodquantity from food21766 as f inner join cart as c on f.foodid=c.foodid where custemail=?";
		
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,email);

			rs=ps.executeQuery();
			
				List<Cart> ls=new ArrayList<>();
				while(rs.next()){
					Cart c=new Cart();
				c.setCartid(rs.getInt(1));
				c.setEmail(rs.getString(2));
				c.setFoodname(rs.getString(3));
				c.setFoodprice(rs.getDouble(4));
				c.setFoodquantity(rs.getInt(5));
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
	public boolean clearcart(String email) {
	try(Connection conn= DBConnection.getConnection())
	{
		query="select orderid from foodorder where email=?";
		ps=conn.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			query="delete from cart where custemail=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, email);
			ps.executeUpdate();
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		return false;
	}
}
