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

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);
		
		CtrlTeachingMaterial ctrlTeachingMaterial=new CtrlTeachingMaterial();
		CtrlSubjects ctrlSubject=new CtrlSubjects();
		
		TeachingMaterial teachingMaterialSearch=new TeachingMaterial();
		Subject subjectSearch=new Subject();
		ArrayList <TeachingMaterial> teachingMaterialArray=new ArrayList();
		
		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);	

		
		teachingMaterialSearch.setTitle(request.getParameter("title"));
		subjectSearch.setName(request.getParameter("subject")); 
		
		//teachingMaterialSearch.setMaterialSubject(ctrlSubject.getByName(subjectSearch));
		
		teachingMaterialArray=ctrlTeachingMaterial.getTeachingMaterials(teachingMaterialSearch);
		
		request.getSession().setAttribute("tmArray",teachingMaterialArray);
		
	    request.getRequestDispatcher("AddTeachingMaterialToOrder.jsp").forward(request, response);

	}

}
