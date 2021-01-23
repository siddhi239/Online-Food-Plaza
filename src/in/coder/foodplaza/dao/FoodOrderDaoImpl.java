package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import in.coder.foodplaza.pojo.Food;
import in.coder.foodplaza.pojo.FoodOrder;
import in.coder.foodplaza.utility.DBConnection;

public class FoodOrderDaoImpl implements FoodOrderDao{
	PreparedStatement ps=null;
	int rows=0;
	double tbill=0.0;
	String query=null;
	
	@Override
	public int Placeorder(String email) 
	{
		int orderId=0;
		String odate=new Date().toString();
	try(Connection conn=DBConnection.getConnection())
	{
		query="select sum(food21766.foodprice * cart.foodquantity) as total from food21766 inner join cart on food21766.foodid=cart.custemail=?";  
		ps=conn.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		FoodOrder fd=new FoodOrder();
		while(rs.next())
		{
			tbill=rs.getDouble("total");
		}
		query="insert into foodorder(email,totalbill,orderdate) values(?,?,?)";
		ps=conn.prepareStatement(query);
		ps.setString(1,email);
		ps.setDouble(2, tbill);
		ps.setString(3, odate);
		rows=ps.executeUpdate();
		if(rows>0)
		{
			ps=conn.prepareStatement("select orderid from foodorder where email=? and orderdate=?");
			ps.setString(1, email);
			ps.setString(2, odate);
			rs=ps.executeQuery();
			if(rs.next())
				orderId= rs.getInt(1);
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		return orderId;
	}
}
