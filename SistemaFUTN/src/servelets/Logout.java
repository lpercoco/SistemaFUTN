package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.User;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */   
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);
		
		request.getSession().setAttribute("userAuthenticated",null);
		
		request.getSession().setAttribute("orders",null);
		
		request.getSession().setAttribute("orderToShow",null);


		request.getRequestDispatcher("Login.jsp").forward(request, response); 
		
	}

}
