package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.User;
import negocio.CtrlUsers;
import utils.ApplicationException;

/**
 * Servlet implementation class UserRUD
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);

		CtrlUsers ctrlUser=new CtrlUsers();

		User userLogged = (User)request.getSession().getAttribute("userAuthenticated");
		User userNewValues =new User();

		userNewValues.setMail(request.getParameter("mail"));
		userNewValues.setPhone1(request.getParameter("phone1"));
		userNewValues.setPhone2(request.getParameter("phone2"));
		userNewValues.setAdress(request.getParameter("adress"));
		userNewValues.setPassword(request.getParameter("password"));

		userLogged=ctrlUser.update(userLogged,userNewValues);

		request.getSession().setAttribute("userAuthenticated",userLogged);	
		request.getSession().setAttribute("message","User information changed successfully");

		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}		
}


