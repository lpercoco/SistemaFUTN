package servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Order;
import entidades.OrderDetail;
import entidades.TeachingMaterial;
import entidades.User;
import futn.CopyPrice;
import negocio.CtrlFutn;
import negocio.CtrlOrders;
import negocio.CtrlTeachingMaterial;
import utils.ApplicationException;

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
		CtrlOrders ctrlOrders = new CtrlOrders();

		OrderDetail orderDetail;
		CopyPrice copyPrice;
		Order order;
		User student;

		String[] tmCodesArray = request.getParameterValues("checkboxgroup");
		Object objOrder=request.getSession().getAttribute("order");
		Object objCopyPrice=request.getSession().getAttribute("copyPrice");
		
		//clean message's
		request.getSession().setAttribute("message",null);	
		request.getSession().setAttribute("exceptionMessage",null);	
		
		//If there is no current order in session, create a  new one and set it to the session
		
		if(objOrder!=null){
			order=(Order) objOrder;			
		}else{
			student= (User)request.getSession().getAttribute("userAuthenticated");
			order= new Order(student);
			request.getSession().setAttribute("order",order);
		}

		//If there is no current copy price in session, create a  new one and set it to the session
		
		if(objCopyPrice!=null){
			copyPrice=(CopyPrice) objCopyPrice;
		}else{
			copyPrice=ctrlFutn.getCurrentCopyPrice();
			request.getSession().setAttribute("copyPrice",copyPrice);
		}


		// add each order detail to the order
		try {

			for (int i = 0; i < tmCodesArray.length; i++) {   	    	
				TeachingMaterial tm=new TeachingMaterial();
				int quantity;
				boolean duplex;

				tm=ctrlTM.getTeachingMaterial(new TeachingMaterial(tmCodesArray[i]));

				quantity=Integer.parseInt(request.getParameter("qty"+tmCodesArray[i]));
				duplex=Boolean.parseBoolean(request.getParameter("duplex"+tmCodesArray[i]));

				orderDetail = new OrderDetail(tm,quantity,duplex,copyPrice);


				order=ctrlOrders.setOrderDetail(order,orderDetail);

			}

			//update order in session
			request.getSession().setAttribute("order",order);
			request.getSession().setAttribute("message","Items added successfully");	

		} catch (ApplicationException e) {
			request.getSession().setAttribute("exceptionMessage",e.getMessage());	

		}finally {

			//clean selected tmS from the search in the session
			request.getSession().setAttribute("tmArray",null);

			request.getRequestDispatcher("AddTeachingMaterialToOrder.jsp").forward(request, response); // cambiar a que pagina redirige luego de registrar orden	

		}

	}
}
