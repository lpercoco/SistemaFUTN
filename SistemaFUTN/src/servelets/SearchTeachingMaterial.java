package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import entidades.Subject;
import entidades.TeachingMaterial;
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
		CtrlTeachingMaterial ctrlTM=new CtrlTeachingMaterial();
		TeachingMaterial tm=new TeachingMaterial();
		Subject s=new Subject();
		ArrayList <TeachingMaterial> tmArray=new ArrayList();
		
		tm.setTitle(request.getParameter("title"));
		s.setName(request.getParameter("subject")); //si o si ambos obligatorios?
		tm.setMaterialSubject(s);
		
		tmArray=ctrlTM.getTeachingMaterials(tm);
	    request.getSession().setAttribute("tmArray",tmArray);
		
	    request.getRequestDispatcher("AddOrder.jsp").forward(request, response);

	}

}
