package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.TeachingMaterial;
import negocio.CtrlTeachingMaterial;

/**
 * Servlet implementation class AddTeachingMaterialToOrder
 */
@WebServlet("/AddTeachingMaterialToOrder")
public class AddTeachingMaterialToOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeachingMaterialToOrder() {
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
		String[] tmCodesArray = request.getParameterValues("checkboxgroup");
		CtrlTeachingMaterial ctrl = new CtrlTeachingMaterial();
		ArrayList<TeachingMaterial> items=null;		
		Object objItems=request.getSession().getAttribute("items");
		
  		
		if(objItems!=null){
			items=(ArrayList<TeachingMaterial>) objItems;
		}else{
			items=new ArrayList<TeachingMaterial>();
		}
		
        	
       for (int i = 0; i < tmCodesArray.length; i++) {  
    	 TeachingMaterial tm=new TeachingMaterial();
         
    	 tm.setCode(Integer.parseInt(tmCodesArray[i]));  
         items.add(ctrl.getTeachingMaterial(tm));
    	   
		}
       
         
       request.getSession().setAttribute("items", items);
       request.getSession().setAttribute("tmCodes",tmCodesArray); //prueba	    
	   request.getRequestDispatcher("AddOrder.jsp").forward(request, response); // cambiar a que pagina redirige luego de registrar orden
	}

}
