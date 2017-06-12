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
		
		CtrlUsers ctrl= new CtrlUsers();
		User u=new User();
		User user;
		
		u.setLegajo(request.getParameter("legajoLogin"));
		u.setPassword(request.getParameter("passwordLogin"));
		
		try {
			user=ctrl.validateLogin(u);
			
		    request.getSession().setAttribute("userAuthenticated",user);

			request.getRequestDispatcher("/Home.jsp").forward(request, response); 

			
		} catch (ApplicationException e) {
			e.printStackTrace();
			//si es contraseña incorrecta volver a mostrar pagina login con mensaje
			//si no existe usuario con ese legajo mostrar mensaje ir a facultar a registrarse
		}
		
		
	}

}
