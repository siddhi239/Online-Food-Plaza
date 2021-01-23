package in.coder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.foodplaza.dao.LoginDaoImpl;
import in.coder.foodplaza.pojo.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	String type;
	String email;
	String pwd, pwd2, opid, npid;
	boolean flag;

	Login login = null;

	LoginDaoImpl loginimpl = new LoginDaoImpl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		if (action!=null && action.equalsIgnoreCase("chngepwd")) {
			email = request.getParameter("lid");
			pwd = request.getParameter("opid");
			pwd2 = request.getParameter("npid");

			if (loginimpl.adminLogin(email, pwd)) {
				flag = loginimpl.changePassword(email, pwd2);
				if (flag == true) {
					response.sendRedirect("Success.html");
				} else {
					response.sendRedirect("Error.html");
				}

			}

		} else {
			type = request.getParameter("typename");

			email = request.getParameter("lid");
			pwd = request.getParameter("pwd");

			if (type.equalsIgnoreCase("admin")) {
				flag = loginimpl.adminLogin(email, pwd);

				if (flag == true) {
					session.setAttribute("adminid", email);
					response.sendRedirect("Index.jsp");
				} else {
					response.sendRedirect("Login.jsp");
				}
			}

			if (type.equalsIgnoreCase("Customer")) {
				flag = loginimpl.custLogin(email, pwd);
				

					if (flag == true) {
						session.setAttribute("custid", email);
						response.sendRedirect("Index.jsp");
					} else {
						response.sendRedirect("Login.jsp");
					}

			}

		}
	}
}
