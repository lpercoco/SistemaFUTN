package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Student;
import negocio.CtrlUsers;

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
		
		CtrlUsers ctrl=new CtrlUsers();
		Student sSearch=new Student();
		Student s=new Student();
		double total=0;
		
		sSearch.setLegajo(request.getParameter("Legajo"));
		s=ctrl.getByLegajo(sSearch);
		total=s.getCredit()+Double.parseDouble(request.getParameter("Credit"));
		s.setCredit(total);
		ctrl.update(s);
	
	    request.getRequestDispatcher("AddCredit.jsp").forward(request, response); // a donde dirigir?

		doGet(request, response);
	}

}
