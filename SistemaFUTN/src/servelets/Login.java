package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Order;
import entidades.OrderDetail;
import entidades.User;
import negocio.CtrlOrders;
import negocio.CtrlUsers;
import utils.ApplicationException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);
		
		CtrlUsers ctrlUsers = new CtrlUsers();
		CtrlOrders ctrlOrders = new CtrlOrders();
		User u=new User();
		User user;
		
		ArrayList<Order> orders ;
		
		u.setLegajo(request.getParameter("legajoLogin"));
		u.setPassword(request.getParameter("passwordLogin"));
		
		try {
			user=ctrlUsers.validateLogin(u);
			
		    request.getSession().setAttribute("userAuthenticated",user);

		    if(!user.isScholar()){
		    	orders=ctrlOrders.getOrders(user);
				request.getSession().setAttribute("orders",orders);
		    }
		    
			request.getRequestDispatcher("/Home.jsp").forward(request, response); 
	
		} catch (ApplicationException e) {
			request.getSession().setAttribute("exceptionMessage",e.getMessage());	
			request.getRequestDispatcher("Login.jsp").forward(request, response); 
		}		
	}

}
