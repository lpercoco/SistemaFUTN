package servelets;

import java.io.IOException;
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
 * Servlet implementation class AddTeachingMaterial
 */
@WebServlet("/AddTeachingMaterial")
public class AddTeachingMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeachingMaterial() {
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
		
		CtrlTeachingMaterial ctrlTeachingMaterial=new CtrlTeachingMaterial();
		CtrlSubjects ctrlSubject=new CtrlSubjects();
		TeachingMaterial teachingMaterial=new TeachingMaterial();
		
		String subjectName=request.getParameter("subject");
				
		teachingMaterial.setTitle(request.getParameter("title"));
		teachingMaterial.setAuthor(request.getParameter("author"));
		teachingMaterial.setDescription(request.getParameter("description"));
		teachingMaterial.setEdition(request.getParameter("edition"));
		teachingMaterial.setNumberOfPages(Integer.parseInt(request.getParameter("numberOfPages")));
		
		
	    try {
		    teachingMaterial.setMaterialSubject(ctrlSubject.getByName(subjectName));
		
		    ctrlTeachingMaterial.add(teachingMaterial);
		    
			request.getSession().setAttribute("message","Teaching material added successfully");

		    request.getRequestDispatcher("Home.jsp").forward(request, response);  

	    } catch (ApplicationException e) {
			request.getSession().setAttribute("exceptionMessage",e.getMessage());
		    request.getRequestDispatcher("AddTeachingMaterial.jsp").forward(request, response);
	    }    		
	}

}
