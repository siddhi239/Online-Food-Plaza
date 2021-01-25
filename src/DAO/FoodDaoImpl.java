package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Food;
import UTILITY.DBConnection;

public class FoodDaoImpl implements FoodDao
{
	Connection con=null;
	
	PreparedStatement ps=null;
	
	ResultSet rs=null;
	
	String query=null;
	
	@Override
	public boolean addFood(Food food) {
		con= DBConnection.getConnection();
		
		query="insert into food21766 (foodname,foodtype,foodprice) values(?,?,?)";
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, food.getFoodname());
			ps.setString(2, food.getFoodtype());
			ps.setDouble(3, food.getFoodprice());
			
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

	public boolean updateFood(Food food) {
		con= DBConnection.getConnection();
		
		query="update food21766 set foodname=?,foodtype=?,foodprice=? where foodid=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(4, food.getFoodid());
			ps.setString(1, food.getFoodname());
			ps.setString(2, food.getFoodtype());
			ps.setDouble(3, food.getFoodprice());
			
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
		

	public boolean deleteFood(int foodid) {
		con= DBConnection.getConnection();
		query="delete from food21766 where foodid=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, foodid);
			
			
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

	
	public Food selectById(int foodid) {
		
con= DBConnection.getConnection();
		
		query="select * from food21766 where foodid=?";
		try {
			ps=con.prepareStatement(query);
			
			ps.setInt(1,foodid);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				Food f=new Food();
				f.setFoodid(rs.getInt(1));
				f.setFoodname(rs.getString("foodname"));
				f.setFoodtype(rs.getString(3));
				f.setFoodprice(rs.getDouble(4));
				return f;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
		
		return null;
	}
	
	public List<Food> selectAll() {
		
		
con= DBConnection.getConnection();
		
		query="select * from food21766";
		try {
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			
				List<Food> ls=new ArrayList<Food>();
				while(rs.next()){
					Food f=new Food();
				f.setFoodid(rs.getInt(1));
				f.setFoodname(rs.getString("foodname"));
				f.setFoodtype(rs.getString(3));
				f.setFoodprice(rs.getDouble(4));
				ls.add(f);
				}
				return ls;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
		return null;
	}
	
}
