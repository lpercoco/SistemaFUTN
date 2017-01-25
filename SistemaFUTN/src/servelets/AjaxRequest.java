package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.json.JSONArray;

import entidades.Subject;
import negocio.CtrlSubjects;

/**
 * Servlet implementation class UploadTecahingMaterial
 */
@WebServlet("/AjaxRequest")
public class AjaxRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	public AjaxRequest() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CtrlSubjects ctrl=new CtrlSubjects();
		ArrayList<Subject> subjects=new ArrayList<Subject>();
		
		subjects=ctrl.getSubjects();
		
		String[] subjectNames=new String[subjects.size()];		
		
    	for (int i = 0; i < subjects.size(); i++) {
    		subjectNames[i]=subjects.get(i).getName();
		}
              
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        
        
        JSONArray arrayObj=new JSONArray();
        
        String query = request.getParameter("term");
        query = query.toLowerCase();
        for(int i=0; i<subjectNames.length; i++) {
            String subject = subjectNames[i].toLowerCase();
            if(subject.startsWith(query)) {
                arrayObj.put(subjectNames[i]);
            }
        }
        
        out.println(arrayObj.toString());
        out.close();
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
