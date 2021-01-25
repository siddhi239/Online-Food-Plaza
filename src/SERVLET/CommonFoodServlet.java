package SERVLET;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.FoodDaoImpl;
import POJO.Food;

/**
 * Servlet implementation class CommonFoodServlet
 */
@WebServlet("/CommonFoodServlet")
public class CommonFoodServlet extends HttpServlet {
	int foodid;
	String foodname,foodtype;
	double foodprice;
	boolean flag;
	
	Food food=null;
	
	FoodDaoImpl foodimpl=new FoodDaoImpl();
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonFoodServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		
		
		String operation=request.getParameter("action");
		if(operation!=null && operation.equalsIgnoreCase("editfood"))
		{
			int foodId=Integer.parseInt(request.getParameter("fid"));
			Food f=foodimpl.selectById(foodId);
			session.setAttribute("food",f);
			response.sendRedirect("UpdateFood.jsp");
		}
		else if(operation!=null && operation.equalsIgnoreCase("delete")) 
		{
			foodid=Integer.parseInt(request.getParameter("fid"));
								
			flag=foodimpl.deleteFood(foodid);
			
			if(flag==true)
			{
				response.sendRedirect("CommonFoodServlet");
			}
			else
			{
				response.sendRedirect("FoodList.jsp");
			}
			
		}
		
		else
		{
			List<Food> foodlist=foodimpl.selectAll();
			session.setAttribute("flist",foodlist);
			response.sendRedirect("FoodList.jsp");
		}
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation=request.getParameter("action");
		if(operation!=null && operation.equalsIgnoreCase("updatefood"))
		{
			foodid=Integer.parseInt(request.getParameter("fid"));
			foodname=request.getParameter("myname");
			foodtype=request.getParameter("myfoodtype");
			foodprice=Double.parseDouble(request.getParameter("price"));
			
			food=new Food();
			
			food.setFoodid(foodid);
			food.setFoodname(foodname);
			food.setFoodtype(foodtype);
			food.setFoodprice(foodprice);
			
			flag=foodimpl.updateFood(food);
			
			if(flag ==true)
			{
				response.sendRedirect("CommonFoodServlet");
			}
			else
			{
				response.sendRedirect("UpdateFood.jsp");
			}
		}
		else
		{
			System.out.println("Enter food details");
			foodname=request.getParameter("myname");
			foodtype=request.getParameter("myfoodtype");
			foodprice=Double.parseDouble(request.getParameter("price"));
			
			
			food=new Food();
			
			food.setFoodname(foodname);
			food.setFoodtype(foodtype);
			food.setFoodprice(foodprice);
			
			flag=foodimpl.addFood(food);
			
			if(flag ==true)
			{
				response.sendRedirect("Success.html");
			}
			else
			{
				response.sendRedirect("Error.html");
			}
		
		}
			
		
		
	}

}
