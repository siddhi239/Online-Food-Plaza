package in.coder.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.coder.foodplaza.utility.DBConnection;

public class LoginDaoImpl implements LoginDao{
	Connection con=null;
	
	PreparedStatement ps=null;
	
	ResultSet rs=null;
	
	String query=null;
	
	
	@Override
	public boolean custLogin(String email, String pwd) {
		con= DBConnection.getConnection();
		
		query="select * from Customer21766 where email=? and password=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,pwd);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean adminLogin(String email, String pwd) {
con= DBConnection.getConnection();
		
		query="select * from Admin21766 where adminEmail=? and adminPass=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2, pwd);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	@Override
	public boolean changePassword(String email, String pwd) {
		con= DBConnection.getConnection();
		
		query="update Admin21766 set adminPass=? where adminEmail=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,pwd);
			ps.setString(2, email);
			int i=ps.executeUpdate();
			System.out.println(ps);
			if(i>0)
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
