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

		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);
		
		CtrlTeachingMaterial ctrlTM = new CtrlTeachingMaterial();
		CtrlFutn ctrlFutn = new CtrlFutn();
		CtrlOrders ctrlOrders = new CtrlOrders();

		OrderDetail orderDetail;
		CopyPrice copyPrice;
		Order order;
		User student;

		String[] tmCodesArray = request.getParameterValues("checkboxgroup"); //session?
		Object objOrder=request.getSession().getAttribute("order");
		Object objCopyPrice=request.getSession().getAttribute("copyPrice");

		request.getSession().setAttribute("exceptionMessage",null);
		request.getSession().setAttribute("message",null);	


		//si no existe una orden en la session, instancia una nueva y la setea
		//luego los guarda en la session
		if(objOrder!=null){
			order=(Order) objOrder;			
		}else{
			student= (User)request.getSession().getAttribute("userAuthenticated");
			//considerar caso que no este logiado¿?
			order= new Order(student);
			request.getSession().setAttribute("order",order);
		}


		//si no existe copyPrice en la session, lo pide y lo guarda en la session
		if(objCopyPrice!=null){
			copyPrice=(CopyPrice) objCopyPrice;
		}else{
			copyPrice=ctrlFutn.getActualCopyPrice();
			request.getSession().setAttribute("copyPrice",copyPrice);
		}


		//crea cada uno de los nuevos orderdetails, valida que sea suficiente el credito
		//y lo agrega a la orden
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
			//si alcanzo el credito y pudo agregar todos los apuntes
			//guarda la orden en la session
			request.getSession().setAttribute("order",order);
			request.getSession().setAttribute("message","Items added successfully");	

		} catch (ApplicationException e) {
			//se lanza en el caso de que algun apunte supere el credito disponible
			request.getSession().setAttribute("exceptionMessage",e.getMessage());	

		}finally {

			request.getSession().setAttribute("tmArray",null);

			request.getRequestDispatcher("AddTeachingMaterialToOrder.jsp").forward(request, response); // cambiar a que pagina redirige luego de registrar orden	

		}

	}
}
