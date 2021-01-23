package in.coder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.foodplaza.dao.CustDaoImpl;
import in.coder.foodplaza.pojo.Customer;
import in.coder.foodplaza.pojo.Food;

/**
 * Servlet implementation class CommonCustomerServlet
 */
@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	int id;
	String name,email,password;
	long contact;
	String address;
	
	Customer customer=null;
	

	CustDaoImpl custimpl=new CustDaoImpl();
	boolean flag;

	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonCustomerServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
	HttpSession session=request.getSession();
	String operation=request.getParameter("action");
	
	if(operation!=null && operation.equalsIgnoreCase("editcustomer"))
	{
		int customerId=Integer.parseInt(request.getParameter("cid"));
		Customer c=custimpl.selectById(customerId);
		session.setAttribute("customer",c);
		response.sendRedirect("UpdateCustomer.jsp");
	}
	else if(operation!=null && operation.equalsIgnoreCase("delete"))
	{
		id=Integer.parseInt(request.getParameter("cid"));
		
		flag=custimpl.deleteCustomer(id);
		
		if(flag ==true)
		{
			response.sendRedirect("CommonCustomerServlet");
		}
		else
		{
			response.sendRedirect("CustomerList.jsp");
		}
	}
	else
	{
		List<Customer> custlist=custimpl.selectAll();
		session.setAttribute("clist",custlist);
		response.sendRedirect("CustomerList.jsp");
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation=request.getParameter("action");
		if(operation!=null && operation.equalsIgnoreCase("updatecustomer"))
		{
		id=Integer.parseInt(request.getParameter("cid"));
		password=request.getParameter("pname");
		name=request.getParameter("cname");
		email=request.getParameter("nmail");
		contact=Long.parseLong(request.getParameter("contact"));
		address=request.getParameter("myaddr");
		
		customer=new Customer();
		
		customer.setId(id);
		customer.setName(name);
		customer.setPassword(password);
		customer.setEmail(email);
		customer.setContact(contact);
		customer.setAddress(address);
		
		flag=custimpl.updateCustomer(customer);
		
		if(flag ==true)
		{
			response.sendRedirect("CommonCustomerServlet");
		}
		else
		{
			response.sendRedirect("UpdateCustomer.jsp");
		}
		}
		else{
		System.out.println("Enter Customer Details");
		name=request.getParameter("cname");
		password=request.getParameter("pname");
		email=request.getParameter("nmail");
		contact=Long.parseLong(request.getParameter("contact"));
		address=request.getParameter("myaddr");
		
		customer=new Customer();
		
		customer.setName(name);
		customer.setPassword(password);
		customer.setEmail(email);
		customer.setContact(contact);
		customer.setAddress(address);
		
		flag=custimpl.addCustomer(customer);
		
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
