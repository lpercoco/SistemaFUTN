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
@WebServlet("/UserRUD")
public class UserRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRUD() {
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

		// hacer un servelet por aca boton?

		User s= new User();
				
		if(request.getParameter("search") != null){
			User sSearch= new User();
			sSearch.setLegajo(request.getParameter("legajo"));
			try {
				s=ctrlUser.getByLegajo(sSearch);
			} catch (ApplicationException e) {
                //excepcion cuando no encuentra legajo
				e.printStackTrace();
			}
			if(s!=null){
			    request.getSession().setAttribute("User", s );
			    request.getRequestDispatcher("UserRUD.jsp").forward(request, response);
			}	
		}
		
		
		if(request.getParameter("delete") != null){
			s=(User)(request.getSession().getAttribute("User"));
			try {
				ctrlUser.delete(s);
				request.getSession().removeAttribute("User");
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    request.getRequestDispatcher("UserRUD.jsp").forward(request, response);

		}
		if(request.getParameter("update") != null){
			s=(User)(request.getSession().getAttribute("User"));
			s.setMail(request.getParameter("mail"));
			s.setPhone1(request.getParameter("phone1"));
			s.setPhone2(request.getParameter("phone2"));
			s.setAdress(request.getParameter("adress"));
			try {
				ctrlUser.update(s);
				request.getSession().removeAttribute("User");
			} catch (ApplicationException e) {
				// excepcion no puede  actualizar
				e.printStackTrace();
			}
		    request.getRequestDispatcher("UserRUD.jsp").forward(request, response); //direccion al terminal

		}
		
		doGet(request, response);
	}

}
