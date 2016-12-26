package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import entidades.Student;
import entidades.Subject;
import entidades.TeachingMaterial;
import negocio.CtrlSubjects;
import negocio.CtrlTeachingMaterial;
import negocio.CtrlUsers;

/**
 * Servlet implementation class AddTeachingMaterial
 */
@WebServlet("/AddTeachingMaterial")
public class AddTeachingMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CtrlTeachingMaterial ctrlTM;
	CtrlSubjects ctrlS;
	TeachingMaterial tm;
	Subject ms;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeachingMaterial() {
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

        ctrlTM=new CtrlTeachingMaterial();
        ctrlS=new CtrlSubjects();
        tm=new TeachingMaterial();
        ms=new Subject();
				
		tm.setTitle(request.getParameter("title"));
		
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("author"));
		System.out.println(request.getParameter("numberOfPages"));
		
		tm.setAuthor(request.getParameter("author"));
		tm.setDescription(request.getParameter("description"));
		tm.setEdition(request.getParameter("edition"));
		tm.setEditorial(request.getParameter("editorial"));
		tm.setNumberOfPages(Integer.parseInt(request.getParameter("numberOfPages")));
		tm.setPublicationYear(request.getParameter("PublicationYear"));
		
	    ms.setName(request.getParameter("subject"));
		
		tm.setMaterialSubject(ctrlS.getByName(ms)); //esta bien? que pasa en caso de excepcion? 
		
		ctrlTM.add(tm);
	
	    request.getRequestDispatcher("AddTeachingMaterial.jsp").forward(request, response);
	}

}
