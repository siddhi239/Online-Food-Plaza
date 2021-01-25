package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import UTILITY.DBConnection;

public class FoodOrderDaoImpl implements FoodOrderDao{
	PreparedStatement ps=null;
	int rows=0;
	double tbill=0.0;
	String query=null,query2=null;
	ResultSet rs;

	@Override
	public int Placeorder(String email,double totalbill) 
	{
		int orderId=0;
		String odate=new Date().toString();
		Connection conn=DBConnection.getConnection();
		try
		{
			
			query="insert into foodorder(email,totalbill,orderdate) values(?,?,?)";
			ps=conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setDouble(2, totalbill);
			ps.setString(3, odate);
			rows=ps.executeUpdate();
			if(rows>0)
			{
				//System.out.println("order placed''''''''");
				query2="select orderid from foodorder where email=? and orderdate=?";
			
				ps=conn.prepareStatement(query2);
				ps.setString(1, email);
				ps.setString(2, odate);
				//System.out.println(ps);
				rs=ps.executeQuery();
				if(rs.next())
					orderId= rs.getInt(1);
				System.out.println("new Id of order"+orderId);
				return orderId;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("new Id of order"+orderId);
		return orderId;
	}
}
