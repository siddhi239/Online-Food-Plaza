package SERVLET;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDaoImpl;
import DAO.FoodOrderDaoImpl;
import POJO.Cart;


@SuppressWarnings("serial")
@WebServlet("/CommonOrdertServlet")
public class CommonOrdertServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CartDaoImpl cdl = new CartDaoImpl();
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		String email =(String)session.getAttribute("custid");

		if(action!=null && action.equals("addtocart"))
		{
			Cart c=new Cart();
			

			int fid = Integer.parseInt( request.getParameter("fid") );
			
			c.setFoodid(fid);
			c.setEmail(email);
			c.setFoodquantity(1);
			
			boolean status = cdl.isFoodinCart(fid, email);
			
			if(status){
				request.setAttribute("success","Food already added to Cart");
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
			else
			{
				status=cdl.add_to_cart(c);
				if(status == true)
				{
				request.setAttribute("success","Food added successfully");
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
				}
				else{
					request.setAttribute("fail","Food not added");
					RequestDispatcher rd=request.getRequestDispatcher("FoodList.jsp");
					rd.forward(request, response);
				}
			}
			

		}
		else if(action!=null && action.equals("deleteCart")){
			int cid=Integer.parseInt(request.getParameter("cid"));

			boolean status = cdl.deleteCart(cid);	
			
			if(status == true)
			{
				request.setAttribute("success", "Food deleted successfully");
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				request.setAttribute("fail", "Food not deleted");
				RequestDispatcher rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}
			
		}
		else 
		{
		
			List<Cart> clist= cdl.display_cart(email);
			session.setAttribute("clist", clist);
			response.sendRedirect("showCart.jsp");
			
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome");
		HttpSession session=request.getSession();
		FoodOrderDaoImpl odimpl=new FoodOrderDaoImpl();
		CartDaoImpl daoimpl=new CartDaoImpl();
		double tbill=0.0;
		String fq[]=request.getParameterValues("foodquantity");
		String fp[]=request.getParameterValues("foodprice");
		System.out.println(fq[0]);
		System.out.println(fp[0]);
		for(int i=0;i<fq.length;i++){
			tbill+=Integer.parseInt(fq[i])*Double.parseDouble(fp[i]);
		}
		System.out.println(tbill);
		String email=(String)session.getAttribute("custid");
		int oid=odimpl.Placeorder(email, tbill);
		if(oid>0)
		{
			boolean flag=daoimpl.clearcart(email);
			if(flag)
			{
				request.setAttribute("success","Your order id is="+oid+"totalbill="+tbill);
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
		}
		
			
			
			
			
		
		
		
	}
}
