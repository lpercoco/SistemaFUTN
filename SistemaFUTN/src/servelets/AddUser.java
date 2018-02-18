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
 * Servlet implementation class UserAdd
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		
		User student=new User();
		
		student.setLegajo(Integer.parseInt(request.getParameter("legajo")));
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setMail(request.getParameter("mail"));
		student.setPhone1(request.getParameter("phone1"));
		student.setPhone2(request.getParameter("phone2"));
		student.setCredit(Double.parseDouble(request.getParameter("credit")));
		student.setAdress(request.getParameter("adress"));
		student.setPassword(request.getParameter("password"));
		
		try {
			ctrlUser.addNewStudent(student);
			request.getSession().setAttribute("message","User added successfully");
			request.getRequestDispatcher("/Home.jsp").forward(request, response); 
			
		} catch (ApplicationException e) {
			request.getSession().setAttribute("exceptionMessage",e.getMessage());
			request.getRequestDispatcher("AddUser.jsp").forward(request, response); 
		} 
	}
}
