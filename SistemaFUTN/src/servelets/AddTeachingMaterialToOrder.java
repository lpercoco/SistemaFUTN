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
import futn.CopyPrice;
import negocio.CtrlFutn;
import negocio.CtrlTeachingMaterial;

@WebServlet("/AddTeachingMaterialToOrder")
public class AddTeachingMaterialToOrder extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AddTeachingMaterialToOrder() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlTeachingMaterial ctrlTM = new CtrlTeachingMaterial();
		CtrlFutn ctrlFutn = new CtrlFutn();
		
		ArrayList<OrderDetail> orderDetails=null;
		OrderDetail orderDetail;
		CopyPrice copyPrice;
		
		String[] tmCodesArray = request.getParameterValues("checkboxgroup"); //session?
		Object objOrderDetails=request.getSession().getAttribute("orderDetails");
		Object objCopyPrice=request.getSession().getAttribute("copyPrice");
		
		//si no existen orderDetails en la session, crea el nuevo array
		//luego los guarda en la session
		if(objOrderDetails!=null){
			orderDetails=(ArrayList<OrderDetail>) objOrderDetails;
		}else{
			orderDetails=new ArrayList<OrderDetail>();
		}
		
	    
		//si no existe copyPrice en la session, lo pide y lo guarda en la session
		if(objCopyPrice!=null){
			copyPrice=(CopyPrice) objCopyPrice;
		}else{
			copyPrice=ctrlFutn.getActualCopyPrice();
			request.getSession().setAttribute("copyPrice",copyPrice);
		}
		
		//crea cada uno de los nuevos orderdetails y los agrega al array
		//refactor?
	    for (int i = 0; i < tmCodesArray.length; i++) {   	    	
	    	TeachingMaterial tm=new TeachingMaterial();
	    	int quantity;
	    	boolean duplex;
	    	
	    	tm=ctrlTM.getTeachingMaterial(new TeachingMaterial(tmCodesArray[i]));
	      	
	    	quantity=Integer.parseInt(request.getParameter("qty"+tmCodesArray[i]));
	        duplex=Boolean.parseBoolean(request.getParameter("duplex"+tmCodesArray[i]));
	    		    	
	        orderDetail = new OrderDetail(tm,quantity,duplex,copyPrice);
	        
	    	orderDetails.add(orderDetail);
	  		}
       
       request.getSession().setAttribute("orderDetails", orderDetails);
       
       
	   request.getRequestDispatcher("AddTeachingMaterialToOrder.jsp").forward(request, response); // cambiar a que pagina redirige luego de registrar orden	
	}
}
