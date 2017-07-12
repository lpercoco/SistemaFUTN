package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Subject;
import entidades.TeachingMaterial;
import negocio.CtrlSubjects;
import negocio.CtrlTeachingMaterial;
import utils.ApplicationException;

/**
 * Servlet implementation class SearchTeachingMaterial
 */
@WebServlet("/SearchTeachingMaterial")
public class SearchTeachingMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchTeachingMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CtrlTeachingMaterial ctrlTeachingMaterial=new CtrlTeachingMaterial();

		TeachingMaterial teachingMaterialSearch=new TeachingMaterial();
		Subject subjectSearch=new Subject();
		ArrayList <TeachingMaterial> teachingMaterialArray=new ArrayList<TeachingMaterial>();


		teachingMaterialSearch.setTitle(request.getParameter("title"));
		subjectSearch.setName(request.getParameter("subject")); 

		teachingMaterialSearch.setMaterialSubject(subjectSearch);

		try {
			teachingMaterialArray=ctrlTeachingMaterial.getTeachingMaterials(teachingMaterialSearch);
		} catch (ApplicationException e) {
			request.getSession().setAttribute("exceptionMessage",e.getMessage());
		}

		request.getSession().setAttribute("tmArray",teachingMaterialArray);

		request.getRequestDispatcher("AddTeachingMaterialToOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
