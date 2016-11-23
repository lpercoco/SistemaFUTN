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
 * Servlet implementation class UserCrud
 */
@WebServlet("/UserCrud")
public class UserCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCrud() {
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
		
		Student student=new Student();
		
		student.setLegajo(request.getParameter("legajo"));
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setMail(request.getParameter("mail"));
		student.setPhone1(request.getParameter("phone1"));
		student.setPhone2(request.getParameter("phone2"));
		student.setCredit(Double.parseDouble(request.getParameter("credit")));
		student.setAdress(request.getParameter("adress"));
		
		ctrlUser.add(student); //manejo de excepcion en controlador

		
		doGet(request, response);
	}

}
