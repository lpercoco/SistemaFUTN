package servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.OrderDetail;
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
		
		//falta exepcion  add to cart vacio
		
		String[] tmCodesArray = request.getParameterValues("checkboxgroup"); //session?
		CtrlTeachingMaterial ctrl = new CtrlTeachingMaterial();
		
		ArrayList<OrderDetail> orderDetails=null;
		Object objOrderDetails=request.getSession().getAttribute("orderDetails");
		
		if(objOrderDetails!=null){
			orderDetails=(ArrayList<OrderDetail>) objOrderDetails;
		}else{
			orderDetails=new ArrayList<OrderDetail>();
		}
		
		
	    for (int i = 0; i < tmCodesArray.length; i++) {   
	    	OrderDetail od=new OrderDetail();
	    	TeachingMaterial tm=new TeachingMaterial();
	    	
	      	tm.setCode(Integer.parseInt(tmCodesArray[i]));
	      	
	      	od.setNumberOfCopies(Integer.parseInt(request.getParameter("qty"+tmCodesArray[i]))); //excepcion?
	      	od.setDuplex( Boolean.parseBoolean(request.getParameter("duplex"+tmCodesArray[i]))); //exp?
	    	od.setItem(ctrl.getTeachingMaterial(tm));//excepcion?	
	    	od.setState(false);
	    	od.setParcialAmount();
	    	
	    	orderDetails.add(od);
	  		}
       
       request.getSession().setAttribute("orderDetails", orderDetails);
	   request.getRequestDispatcher("AddTeachingMaterialToOrder.jsp").forward(request, response); // cambiar a que pagina redirige luego de registrar orden	
	}
}
