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
 * Servlet implementation class AddCredit
 */
@WebServlet("/AddCredit")
public class AddCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCredit() {
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

		CtrlUsers ctrl=new CtrlUsers();
		User s=new User();
        
		Double creditToAdd=Double.parseDouble(request.getParameter("credit"));
		
		s.setLegajo(request.getParameter("legajo"));
		
		try {
			s=ctrl.getByLegajo(s);
			
			ctrl.addCredit(s,creditToAdd);
			
			request.getSession().setAttribute("message","Credit added successfully");
			request.getRequestDispatcher("Home.jsp").forward(request, response);

		} catch (ApplicationException e) {
			//no existe alumno
			request.getSession().setAttribute("exceptionMessage",e.getMessage());
		    request.getRequestDispatcher("AddCredit.jsp").forward(request, response);
		}

	}

}
