package in.coder.foodplaza.dao;

import java.util.List;

import in.coder.foodplaza.pojo.Food;

public interface FoodDao {
	boolean addFood(Food food);
	boolean updateFood(Food food);
	boolean deleteFood(int foodid);
	Food selectById(int foodid);
	List<Food> selectAll();
	
}
