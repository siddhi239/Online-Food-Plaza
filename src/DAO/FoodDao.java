package DAO;

import java.util.List;

import POJO.Food;

public interface FoodDao {
	boolean addFood(Food food);
	boolean updateFood(Food food);
	boolean deleteFood(int foodid);
	Food selectById(int foodid);
	List<Food> selectAll();
	
}
