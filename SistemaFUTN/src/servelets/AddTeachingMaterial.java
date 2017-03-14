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

		CtrlTeachingMaterial ctrlTM=new CtrlTeachingMaterial();
		CtrlSubjects ctrlS=new CtrlSubjects();
		TeachingMaterial tm=new TeachingMaterial();
		Subject ms=new Subject();
		
				
		tm.setTitle(request.getParameter("title"));
		tm.setAuthor(request.getParameter("author"));
		tm.setDescription(request.getParameter("description"));
		tm.setEdition(request.getParameter("edition"));
		tm.setNumberOfPages(Integer.parseInt(request.getParameter("numberOfPages")));
		tm.setPublicationYear(request.getParameter("PublicationYear"));
		
	    ms.setName(request.getParameter("subject"));
		
		tm.setMaterialSubject(ctrlS.getByName(ms)); //excepcion en caso de ingreso de subject inexistente 
		
		ctrlTM.add(tm); //excepcion en caso de que no se pueda agregar?
	
	    request.getRequestDispatcher("AddTeachingMaterial.jsp").forward(request, response); //pagina donde se redirige 
	}

}
