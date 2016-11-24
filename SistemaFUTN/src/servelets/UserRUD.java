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

		CtrlUsers ctrlUser=new CtrlUsers();
		Student s= new Student();
		
		//request.getSession().removeAttribute("student");
		
		if(request.getParameter("read") != null){
			Student sSearch= new Student();
			sSearch.setLegajo(request.getParameter("Legajo"));
			s=ctrlUser.getByLegajo(sSearch);
			if(s!=null){
			    request.getSession().setAttribute("student", s );
			    request.getRequestDispatcher("UserRUD.jsp").forward(request, response);
			}	
		}
		
		
		if(request.getParameter("delete") != null){
			s=(Student)(request.getSession().getAttribute("student"));
			ctrlUser.delete(s);
		    request.getRequestDispatcher("UserRUD.jsp").forward(request, response);

		}
		
		doGet(request, response);
	}

}
