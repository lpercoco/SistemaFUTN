package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Student;
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
		
		CtrlUsers ctrl=new CtrlUsers();
		Student s=new Student();
		double total=0;
		
		s.setLegajo(request.getParameter("legajo"));
		
		try {
			s=ctrl.getByLegajo(s);
			
			total=s.getCredit()+Double.parseDouble(request.getParameter("credit"));
			s.setCredit(total);
			
			try {
				ctrl.update(s);
			} catch (ApplicationException e) {
				e.printStackTrace();
				//que hacer en el caso de que no se pueda registrar en la actualizacion
			}
				
		} catch (ApplicationException e) {
			e.printStackTrace();
			//que hacer en caso de no exista student con ese legajo
		}
		
	    request.getRequestDispatcher("AddCredit.jsp").forward(request, response); // a donde dirigir?

		doGet(request, response);
	}

}
